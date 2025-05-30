package com.rccode.model;

import com.rccode.enumeration.VehicleType;
import com.rccode.exception.ProcessException;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {
    private VehicleType vehicleType;
    private int price;
    private int count;
    private Map<Long, Integer> booking;

    public Vehicle(VehicleType vehicleType, int count, int price) {
        this.vehicleType = vehicleType;
        this.count = count;
        this.price = price;
        this.booking = new HashMap<>();
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getCount() {
        return count;
    }

    public void updateCount(int newCount) {
        this.count = newCount;
    }

    public int getAvailableCount(long slot) {
        return this.count - this.booking.getOrDefault(slot, 0);
    }

    public int getPrice() {
        return price;
    }

    public boolean isBookingAvailable(long slot) {
        int availableCount = getAvailableCount(slot);
        if (availableCount > 0) {
            return true;
        }
        return false;
    }

    public void addBooking(long slot) {
        if (isBookingAvailable(slot)) {
            this.booking.put(slot, this.booking.getOrDefault(slot, 0) + 1);
        } else {
            throw new ProcessException("Add Booking", "Insufficient vehicle available");
        }
    }
}
