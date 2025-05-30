package com.rccode.service;

import com.rccode.constant.AppConstants;
import com.rccode.enumeration.CarType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Booking;
import com.rccode.model.Branch;
import com.rccode.model.BranchVehicle;
import com.rccode.model.Flipkar;

import java.util.LinkedList;
import java.util.List;

public class FlipkarService {

    private Flipkar flipkar;

    public FlipkarService(Flipkar flipkar) {
        this.flipkar = flipkar;
    }

    public void addBranch(String command) {
        String[] commandArray = command.split(AppConstants.DELIMITER);
        String branchName = commandArray[0].trim().substring(1, commandArray[0].length() - 1);

        List<BranchVehicle> vehicles = new LinkedList<>();
        String vehicleCommand = commandArray[1].trim().substring(1, commandArray[1].length() - 1);
        String[] vehicleArray = vehicleCommand.split(AppConstants.DELIMITER);

        for (String vehicleStr : vehicleArray) {
            vehicleStr = vehicleStr.substring(1, vehicleStr.length() - 1);
            String[] vehicleStrArr = vehicleStr.split(AppConstants.SPACE);
            int count = Integer.parseInt(vehicleStrArr[0]);
            CarType carType = CarType.valueOf(vehicleStrArr[1].toUpperCase());
            int price = Integer.parseInt(vehicleStrArr[3].substring(3));
            BranchVehicle vehicle = new BranchVehicle(carType, price, count);
            vehicles.add(vehicle);
        }

        Branch branch = new Branch(branchName, vehicles, new LinkedList<>());
        flipkar.getBranchList().add(branch);
    }

    public void addVehicle(String command) {
        String[] commandArray = command.split(AppConstants.DELIMITER);
        String branchName = commandArray[0].trim().substring(1, commandArray[0].length() - 1);

        String[] vehicleCommand = commandArray[1].trim().substring(1, commandArray[1].length() - 1).split(AppConstants.SPACE);
        int count = Integer.parseInt(vehicleCommand[0]);
        CarType carType = CarType.valueOf(vehicleCommand[1].substring(0, vehicleCommand[1].length() - 1).toUpperCase());

        Branch branch = null;
        for (Branch br : flipkar.getBranchList()) {
            if (branchName.equals(br.getName())) {
                branch = br;
                break;
            }
        }
        if (branch == null) {
            throw new ProcessException("Add Vehicle", "Invalid branch name");
        }

        BranchVehicle vehicle = null;
        for (BranchVehicle v : branch.getVehicles()) {
            if (v.getCarType().equals(carType)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            throw new ProcessException("Add Vehicle", "Invalid vehicle type");
        }

        vehicle.setCount(vehicle.getCount() + count);
    }

    public void rentVehicle(String command) {
        String[] commandArray = command.split(AppConstants.DELIMITER);
        CarType carType = CarType.valueOf(commandArray[0].trim().substring(1, commandArray[0].length() - 1));
        int startTime = Integer.parseInt(commandArray[1].split(AppConstants.SPACE)[2].substring(0, 2));
        int endTime = Integer.parseInt(commandArray[2].split(AppConstants.SPACE)[2].substring(0, 2));

        int minPrice = Integer.MAX_VALUE;
        BranchVehicle selectedVehicle = null;
        //check availability
        for (Branch branch : flipkar.getBranchList()) {
            for (BranchVehicle vehicle : branch.getVehicles()) {
                if (!carType.equals(vehicle.getCarType())) {
                    continue;
                }

                int bookedCount = 0;
                for (Booking booking : vehicle.getBookings()) {
                    if (booking.getStartTime() <= startTime && booking.getEndTime() >= endTime) {
                        bookedCount++;
                    }
                }

                if (vehicle.getCount() > bookedCount && vehicle.getPricePerHour() < minPrice) {
                    selectedVehicle = vehicle;
                    minPrice = selectedVehicle.getPricePerHour();
                }
            }
        }

        //book vehicle
        if (selectedVehicle == null) {
            System.out.println("No availability");
            return;
        }
        Booking newBooking = new Booking(startTime, endTime);
        selectedVehicle.getBookings().add(newBooking);
    }

    public void getAvailableVehicles(String command) {
        String[] commandArray = command.split(AppConstants.DELIMITER);
        String branchName = commandArray[0].trim().substring(1, commandArray[0].length() - 1);
        int startTime = Integer.parseInt(commandArray[1].split(AppConstants.SPACE)[2].substring(0, 2));
        int endTime = Integer.parseInt(commandArray[2].split(AppConstants.SPACE)[2].substring(0, 2));

        //check availability
        for (Branch branch : flipkar.getBranchList()) {
            if (branch.getName().equals(branchName)) {
                for (BranchVehicle vehicle : branch.getVehicles()) {
                    int bookedCount = 0;
                    for (Booking booking : vehicle.getBookings()) {
                        if (booking.getStartTime() <= startTime && booking.getEndTime() >= endTime) {
                            bookedCount++;
                        }
                    }

                    if (vehicle.getCount() > bookedCount) {
                        int availableCount = vehicle.getCount() - bookedCount;
                        System.out.println(availableCount + " '" + vehicle.getCarType().name() + "' for Rs " + vehicle.getPricePerHour());
                    }
                }
            }
        }
    }

    public void printSystemView(String command) {
        String[] commandArray = command.split(AppConstants.DELIMITER);
        int startTime = Integer.parseInt(commandArray[0].split(AppConstants.SPACE)[2].substring(0, 2));
        int endTime = Integer.parseInt(commandArray[1].split(AppConstants.SPACE)[2].substring(0, 2));

        for (Branch branch : flipkar.getBranchList()) {
            for (BranchVehicle vehicle : branch.getVehicles()) {
                int bookedCount = 0;
                for (Booking booking : vehicle.getBookings()) {
                    if (booking.getStartTime() <= startTime && booking.getEndTime() >= endTime) {
                        bookedCount++;
                    }
                }

                System.out.println(branch.getName() + ":");
                if (vehicle.getCount() > bookedCount) {
                    int availableCount = vehicle.getCount() - bookedCount;
                    System.out.println(availableCount + " '" + vehicle.getCarType().name() + "' for Rs " + vehicle.getPricePerHour());
                } else {
                    System.out.println("All " + vehicle.getCarType().name() + " are booked");
                }
            }
        }
    }
}
