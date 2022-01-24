package com.rccode.service.impl;

import com.rccode.dto.*;
import com.rccode.enumeration.VehicleType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Branch;
import com.rccode.model.Vehicle;
import com.rccode.repository.FlipKarRepository;
import com.rccode.repository.FlipKarRepositoryImpl;
import com.rccode.service.BookingService;
import com.rccode.service.CacheService;
import com.rccode.service.FlipkarService;
import com.rccode.service.util.DateUtil;

import java.util.*;

public class FlipkarServiceImpl implements FlipkarService {

    private BookingService bookingService;
    private CacheService cacheService;
    private FlipKarRepository repository;

    private static final String BRANCH_PREFIX = "branch_";

    public FlipkarServiceImpl() {
        this.bookingService = new BookingServiceImpl();
        this.cacheService = new CacheServiceImpl();
        this.repository = new FlipKarRepositoryImpl();
    }

    @Override
    public void addBranch(AddBranchRequest request) {
        String key = BRANCH_PREFIX + request.getName();
        Branch existingBranch = (Branch)cacheService.get(key);
        if (existingBranch != null) {
            throw new ProcessException("Add Branch", "Branch exists with same name");
        }
        existingBranch = repository.getBranchByName(request.getName());
        if (existingBranch != null) {
            cacheService.put(key, existingBranch);
            throw new ProcessException("Add Branch", "Branch exists with same name");
        }
        Branch branch = new Branch(request.getName());
        for (AddBranchRequest.VehicleRequest vehicleRequest : request.getVehicleRequestList()) {
            Vehicle vehicle = new Vehicle(vehicleRequest.getVehicleType(), vehicleRequest.getCount(), vehicleRequest.getPrice());
            branch.addVehicle(vehicle);
        }
        repository.addBranch(branch);
        cacheService.put(key, branch);
    }

    @Override
    public void addVehicle(AddVehicleRequest request) {
        Branch branch = getBranchByName(request.getBranchName());
        Vehicle vehicle = getVehicleByType(branch, request.getVehicleType());
        if (vehicle == null) {
            throw new ProcessException("Add Vehicle", "Vehicle does not exist of this type in this branch");
        }
        vehicle.updateCount(vehicle.getCount() + request.getCount());
    }

    private Branch getBranchByName(String branchName) {
        String key = BRANCH_PREFIX + branchName;
        Branch branch = (Branch)cacheService.get(key);
        if (branch == null) {
            branch = repository.getBranchByName(branchName);
            if (branch == null) {
                throw new ProcessException("Add Vehicle", "Invalid Branch Name");
            }
            cacheService.put(key, branch);
        }
        return branch;
    }

    private Vehicle getVehicleByType(Branch branch, VehicleType vehicleType) {
        for (Vehicle vehicle : branch.getVehicles()) {
            if (vehicleType.equals(vehicle.getVehicleType())) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void printAvailableVehicles(GetAvailableVehicleRequest request) {
        try {
            long startSlot = DateUtil.getStartSlot(request.getStartTime());
            long endSlot = DateUtil.getEndSlot(request.getEndTime());

            Branch branch = getBranchByName(request.getBranchName());
            System.out.println("Printing available vehicles");
            System.out.println("Branch\t\tVehicleType\t\tCount");
            Map<Vehicle, Integer> map = repository.getAvailableVehicles(branch, null, startSlot, endSlot);
            for(Iterator<Map.Entry<Vehicle, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<Vehicle, Integer> entry = it.next();
                System.out.println(branch.getName() + "\t\t" + entry.getKey().getVehicleType().name() + "\t\t" + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProcessException("Rent Vehicle", "Invalid request");
        }
    }

    @Override
    public Map<Vehicle, Integer> getAvailableVehicles(GetAvailableVehicleRequest request) {
        try {
            long startSlot = DateUtil.getStartSlot(request.getStartTime());
            long endSlot = DateUtil.getEndSlot(request.getEndTime());

            List<Branch> branches = repository.getAllBranches();
            Map<Vehicle, Integer> candidateVehicles = new HashMap<>();
            for (Branch branch : branches) {
                Map<Vehicle, Integer> vehicleSet = repository.getAvailableVehicles(branch, null, startSlot, endSlot);
                candidateVehicles.putAll(vehicleSet);
            }
            return candidateVehicles;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProcessException("Rent Vehicle", "Invalid request");
        }
    }

    @Override
    public void printSystemView(PrintSystemViewRequest request) {
        try {
            long startSlot = DateUtil.getStartSlot(request.getStartTime());
            long endSlot = DateUtil.getEndSlot(request.getEndTime());

            List<Branch> branches = repository.getAllBranches();
            System.out.println("Printing system view for slots between " + request.getStartTime() + " and " + request.getEndTime());
            System.out.printf("%-20s%-20s%-20s%-20s%n", "Branch", "Vehicle Type", "Count", "Price");
            for (Branch branch : branches) {
                Map<Vehicle, Integer> map = repository.getAvailableVehicles(branch, null, startSlot, endSlot);
                for(Iterator<Map.Entry<Vehicle, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Vehicle, Integer> entry = it.next();
                    //System.out.println(branch.getName() + "\t\t\t\t" + entry.getKey().getVehicleType().name() + "\t\t\t\t" + entry.getValue() + "\t\t\t\t" + entry.getKey().getPrice());
                    System.out.printf("%-20s%-20s%-20s%-20s%n", branch.getName(), entry.getKey().getVehicleType().name(), entry.getValue(), entry.getKey().getPrice());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProcessException("Rent Vehicle", "Invalid request");
        }
    }

    @Override
    public synchronized void rentVehicle(RentVehicleRequest request) {
        try {
            long startSlot = DateUtil.getStartSlot(request.getStartTime());
            long endSlot = DateUtil.getEndSlot(request.getEndTime());

            List<Branch> branches = repository.getAllBranches();
            Map<Vehicle, Integer> candidateVehicles = new HashMap<>();
            for (Branch branch : branches) {
                Map<Vehicle, Integer> vehicleSet = repository.getAvailableVehicles(branch, request.getVehicleType(), startSlot, endSlot);
                candidateVehicles.putAll(vehicleSet);
            }
            Vehicle selectedVehicle = bookingService.selectVehicleByStrategy(candidateVehicles);
            if (selectedVehicle == null) {
                System.out.println("No vehicle of type: " + request.getVehicleType().name() + " available between " + request.getStartTime() + " and " + request.getEndTime());
                return;
            }
            repository.addBooking(selectedVehicle, startSlot, endSlot);
            System.out.println("Vehicle of type: " + selectedVehicle.getVehicleType().name() + " booked between " + request.getStartTime() + " and " + request.getEndTime() + " for price: " + selectedVehicle.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProcessException("Rent Vehicle", "Invalid request");
        }
    }

}
