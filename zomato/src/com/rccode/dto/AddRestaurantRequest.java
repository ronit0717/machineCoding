package com.rccode.dto;

import java.util.Arrays;
import java.util.List;

public class AddRestaurantRequest {
    private String name;
    private String pincodes; // slash separated
    private String foodName;
    private int foodPrice;
    private int foodQuantity;

    public AddRestaurantRequest(String name, String pincodes, String foodName, int foodPrice, int foodQuantity) {
        this.name = name;
        this.pincodes = pincodes;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
    }

    public String getName() {
        return name;
    }

    public List<String> getPincodes() {
        String[] pincodeArr = this.pincodes.split("/");
        return Arrays.asList(pincodeArr);
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }
}
