package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class Branch {
    private String name;
    private List<Vehicle> vehicles;

    public Branch(String name) {
        this.name = name;
        this.vehicles = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
}
