package com.rccode.service.impl;

import com.rccode.model.Vehicle;
import com.rccode.service.BookingService;

import java.util.Iterator;
import java.util.Map;

public class BookingServiceImpl implements BookingService {

    @Override
    public Vehicle selectVehicleByStrategy(Map<Vehicle, Integer> vehicles) {
        int minPrice = Integer.MAX_VALUE;
        Vehicle selectedVehicle = null;
        for(Iterator<Map.Entry<Vehicle, Integer>> it = vehicles.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Vehicle, Integer> entry = it.next();
            if(entry.getKey().getPrice() < minPrice) {
                minPrice = entry.getKey().getPrice();
                selectedVehicle = entry.getKey();
            }
        }
        return selectedVehicle;
    }
}
