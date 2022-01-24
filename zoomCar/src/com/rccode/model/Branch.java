package com.rccode.model;

import java.util.List;

public class Branch {

    private String name;
    private List<BranchVehicle> vehicles;

    public Branch(String name, List<BranchVehicle> vehicles, List<Booking> bookings) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BranchVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<BranchVehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
