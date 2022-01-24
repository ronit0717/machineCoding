package com.rccode.dto;

public class UpdateQuantityRequest {
    private String restaurantName;
    private int quantity;

    public UpdateQuantityRequest(String restaurantName, int quantity) {
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

