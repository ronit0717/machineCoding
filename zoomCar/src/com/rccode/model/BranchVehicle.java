package com.rccode.model;

import com.rccode.enumeration.CarType;

import java.util.LinkedList;
import java.util.List;

public class BranchVehicle {

    private CarType carType;
    private int pricePerHour;
    private int count;
    private List<Booking> bookings;

    public BranchVehicle(CarType carType, int pricePerHour, int count) {
        this.carType = carType;
        this.pricePerHour = pricePerHour;
        this.count = count;
        this.bookings = new LinkedList<>();
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
