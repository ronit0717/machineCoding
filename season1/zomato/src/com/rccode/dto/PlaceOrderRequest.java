package com.rccode.dto;

public class PlaceOrderRequest {
    private String restaurantName;
    private int quantity;

    public PlaceOrderRequest(String restaurantName, int quantity) {
        this.restaurantName = restaurantName;
        this.quantity = quantity;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getQuantity() {
        return quantity;
    }
}