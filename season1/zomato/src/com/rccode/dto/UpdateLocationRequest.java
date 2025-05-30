package com.rccode.dto;

public class UpdateLocationRequest {
    private String restaurantName;
    private String pincodes; //Slash separated

    public UpdateLocationRequest(String restaurantName, String pincodes) {
        this.restaurantName = restaurantName;
        this.pincodes = pincodes;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String[] getPincodes() {
        return pincodes.split("/");
    }
}
