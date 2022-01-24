package com.rccode.service;

import com.rccode.model.Vehicle;

import java.util.Map;

public interface BookingService {
    Vehicle selectVehicleByStrategy(Map<Vehicle, Integer> vehicles);
}
