package com.rccode.dto;

public class CreateReviewRequest {
    private String restaurantName;
    private int rating;
    private String comment;

    public CreateReviewRequest(String restaurantName, int rating, String comment) {
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
