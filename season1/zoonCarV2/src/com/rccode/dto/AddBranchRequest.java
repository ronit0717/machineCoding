package com.rccode.dto;

import com.rccode.enumeration.VehicleType;

import java.util.List;

public class AddBranchRequest {

    public static class VehicleRequest {
        private VehicleType vehicleType;
        private int count;
        private int price;

        public VehicleRequest(VehicleType vehicleType, int count, int price) {
            this.vehicleType = vehicleType;
            this.count = count;
            this.price = price;
        }

        public VehicleType getVehicleType() {
            return vehicleType;
        }

        public int getCount() {
            return count;
        }

        public int getPrice() {
            return price;
        }
    }

    private String name;
    private List<VehicleRequest> vehicleRequestList;

    public AddBranchRequest(String name, List<VehicleRequest> vehicleRequestList) {
        this.name = name;
        this.vehicleRequestList = vehicleRequestList;
    }

    public String getName() {
        return name;
    }

    public List<VehicleRequest> getVehicleRequestList() {
        return vehicleRequestList;
    }
}
