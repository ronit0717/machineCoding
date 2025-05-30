package com.rccode.model;

import com.rccode.dto.AddRestaurantRequest;

import java.util.LinkedList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<String> serviceablePincodes;
    private List<Food> foods;
    private List<Rating> ratings;
    private Double rating;
    private List<Order> orders;

    public Restaurant(AddRestaurantRequest request) {
        this.name = request.getName();
        this.serviceablePincodes = request.getPincodes();
        this.foods = new LinkedList<>();
        Food food = new Food(request.getFoodName(), request.getFoodPrice(), request.getFoodQuantity());
        this.foods.add(food);
        this.ratings = new LinkedList<>();
        this.rating = null;
        this.orders = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public double getRating() {
        return rating == null ? 0 : rating;
    }

    public void setServiceablePincodes(List<String> serviceablePincodes) {
        this.serviceablePincodes = serviceablePincodes;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public List<String> getServiceablePincodes() {
        return serviceablePincodes;
    }
}
