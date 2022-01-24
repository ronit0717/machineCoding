package com.rccode.service.impl;

import com.rccode.dto.*;
import com.rccode.enumeration.Filter;
import com.rccode.exception.ProcessException;
import com.rccode.model.*;
import com.rccode.repository.SystemRepository;
import com.rccode.service.CacheService;
import com.rccode.service.RatingComputeService;
import com.rccode.service.RestaurantService;

import java.lang.System;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    private CacheService cacheService;
    private SystemRepository systemRepository;
    private RatingComputeService ratingComputeService;

    private final String PREFIX_KEY = "R_";

    public RestaurantServiceImpl(CacheService cacheService, SystemRepository systemRepository) {
        this.cacheService = cacheService;
        this.systemRepository = systemRepository;
        this.ratingComputeService = new RatingComputeServiceImpl();
    }

    @Override
    public void addRestautant(AddRestaurantRequest request) {
        Restaurant restaurant = getRestaurantByName(request.getName());
        if (restaurant != null) {
            throw new ProcessException("Add Restaurant", "Restaurant with this name already exists");
        }
        restaurant = new Restaurant(request);
        systemRepository.addRestaurant(restaurant);
    }

    @Override
    public synchronized void placeOrder(PlaceOrderRequest request) {
        Restaurant restaurant = getRestaurantByName(request.getRestaurantName());
        if (restaurant == null) {
            throw new ProcessException("Place Order", "Invalid Restaurant Name");
        }
        if (request.getQuantity() > restaurant.getFoods().get(0).getQuantity()) {
            throw new ProcessException("Place Order", "Insufficient food quantity");
        }
        User user = systemRepository.getLogedInUser();

        Order order = new Order(user, restaurant.getFoods().get(0), request.getQuantity());
        restaurant.addOrder(order);
        int newQuantity = restaurant.getFoods().get(0).getQuantity() - request.getQuantity();
        restaurant.getFoods().get(0).setQuantity(newQuantity);
        System.out.println("Order placed successfully");
    }

    private List<Restaurant> filterServiceableRestaurants(User user, List<Restaurant> restaurants) {
        List<Restaurant> serviceableRestaurant = new LinkedList<>();
        for (Restaurant restaurant : restaurants) {
            if (isPincodeServiceable(user.getPincode(), restaurant)) {
                serviceableRestaurant.add(restaurant);
            }
        }
        return serviceableRestaurant;
    }

    private boolean isPincodeServiceable(String pincode, Restaurant restaurant) {
        for (String pin : restaurant.getServiceablePincodes()) {
            if (pin.equals(pincode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showRestaurant(ShowRestaurantRequest request) {
        Filter filter = Filter.valueOf(request.getFilter().toUpperCase());
        List<Restaurant> restaurants = systemRepository.getRestaurants();
        User user = systemRepository.getLogedInUser();
        restaurants = filter.filterRestaurant(filterServiceableRestaurants(user, restaurants));
        for (Restaurant restaurant: restaurants) {
            printRestaurantDetails(restaurant);
        }
    }

    @Override
    public void updateLocation(UpdateLocationRequest request) {
        Restaurant restaurant = getRestaurantByName(request.getRestaurantName());
        if (restaurant == null) {
            throw new ProcessException("Update Location", "Invalid Restaurant Name");
        }
        String[] pincodes = request.getPincodes();
        restaurant.setServiceablePincodes(Arrays.asList(pincodes));
        printRestaurantFullDetails(restaurant);
    }

    @Override
    public void updateQuantity(UpdateQuantityRequest request) {
        Restaurant restaurant = getRestaurantByName(request.getRestaurantName());
        if (restaurant == null) {
            throw new ProcessException("Update Location", "Invalid Restaurant Name");
        }
        Food food = restaurant.getFoods().get(0);
        food.setQuantity(food.getQuantity() + request.getQuantity());
        printRestaurantFullDetails(restaurant);
    }

    @Override
    public void addReview(CreateReviewRequest reviewRequest) {
        Restaurant restaurant = getRestaurantByName(reviewRequest.getRestaurantName());
        if (restaurant == null) {
            throw new ProcessException("Update Location", "Invalid Restaurant Name");
        }
        User user = systemRepository.getLogedInUser();
        Rating review = new Rating(reviewRequest, user);
        restaurant.addRating(review);
        double rating = ratingComputeService.computeRating(restaurant.getRatings());
        restaurant.setRating(rating);
    }

    private void printRestaurantDetails(Restaurant restaurant) {
        System.out.println(restaurant.getName() + ", " + restaurant.getFoods().get(0).getName());
    }

    private Restaurant getRestaurantByName(String name) {
        String key = PREFIX_KEY + name;
        Restaurant restaurant = (Restaurant)cacheService.get(key);
        if (restaurant == null) {
            restaurant = systemRepository.getRestaurantByName(name);
            if (restaurant == null) {
                return null;
            }
            cacheService.put(key, restaurant);
        }
        return restaurant;
    }

    private void printRestaurantFullDetails(Restaurant restaurant) {
        System.out.println(restaurant.getName() + ", " + restaurant.getServiceablePincodes() + ", " + restaurant.getFoods().get(0).getName() + " - " + restaurant.getFoods().get(0).getQuantity());
    }
}
