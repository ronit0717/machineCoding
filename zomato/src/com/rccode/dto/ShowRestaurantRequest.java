package com.rccode.dto;

public class ShowRestaurantRequest {
    private String filter;

    public ShowRestaurantRequest(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
