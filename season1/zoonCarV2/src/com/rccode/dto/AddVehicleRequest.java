package com.rccode.dto;

import com.rccode.enumeration.VehicleType;

public class AddVehicleRequest {
    private String branchName;
    private VehicleType vehicleType;
    private int count;

    public AddVehicleRequest(String branchName, VehicleType vehicleType, int count) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.count = count;
    }

    public String getBranchName() {
        return branchName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getCount() {
        return count;
    }
}
