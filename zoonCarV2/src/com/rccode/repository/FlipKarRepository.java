package com.rccode.repository;

import com.rccode.enumeration.VehicleType;
import com.rccode.model.Branch;
import com.rccode.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface FlipKarRepository {
    void addBranch(Branch branch);
    void addVehicle(Branch branch, Vehicle vehicle);
    Branch getBranchByName(String branchName);
    Map<Vehicle, Integer> getAvailableVehicles(Branch branch, VehicleType vehicleType, long startSlot, long endSlot);
    List<Branch> getAllBranches();
    void addBooking(Vehicle vehicle, long startSlot, long endSlot);
}
