package com.rccode.repository;

import com.rccode.enumeration.VehicleType;
import com.rccode.model.Branch;
import com.rccode.model.FlipKar;
import com.rccode.model.Vehicle;

import java.util.*;

public class FlipKarRepositoryImpl implements FlipKarRepository {

    private FlipKar flipKar;

    public FlipKarRepositoryImpl() {
        this.flipKar = new FlipKar();
    }

    @Override
    public void addBranch(Branch branch) {
        this.flipKar.addBranch(branch);
    }

    @Override
    public void addVehicle(Branch branch, Vehicle vehicle) {
        branch.addVehicle(vehicle);
    }

    @Override
    public Branch getBranchByName(String branchName) {
        for (Branch branch : flipKar.getBranches()) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    @Override
    public Map<Vehicle, Integer> getAvailableVehicles(Branch branch, VehicleType vehicleType, long startSlot, long endSlot) {
        Map<Vehicle, Integer> resultMap = new HashMap<>();
        for (Vehicle vehicle : branch.getVehicles()) {
            if (vehicleType != null && vehicleType!=vehicle.getVehicleType()) {
                continue;
            }
            int availableCount = vehicle.getAvailableCount(startSlot);
            if (availableCount > 0) {
                resultMap.put(vehicle, availableCount);
            }
        }

        for (long slot = startSlot + 1; slot <= endSlot; slot++) {
            for(Iterator<Map.Entry<Vehicle, Integer>> it = resultMap.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<Vehicle, Integer> entry = it.next();
                if(!entry.getKey().isBookingAvailable(slot)) {
                    it.remove();
                } else {
                    int currAvailableCount = entry.getKey().getAvailableCount(slot);
                    if(currAvailableCount < entry.getValue()) {
                        entry.setValue(currAvailableCount);
                    }
                }
            }
        }

        return resultMap;
    }

    @Override
    public List<Branch> getAllBranches() {
        return flipKar.getBranches();
    }

    @Override
    public void addBooking(Vehicle vehicle, long startSlot, long endSlot) {
        for (long slot = startSlot; slot <= endSlot; slot++) {
            vehicle.addBooking(slot);
        }
    }


}
