package com.rccode.dto;

import com.rccode.enumeration.VehicleType;

public class RentVehicleRequest {
    private VehicleType vehicleType;
    private String startTime;
    private String endTime;

    public RentVehicleRequest(VehicleType vehicleType, String startTime, String endTime) {
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
