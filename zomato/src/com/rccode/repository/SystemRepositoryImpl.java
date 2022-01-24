package com.rccode.repository;

import com.rccode.exception.ProcessException;
import com.rccode.model.Restaurant;
import com.rccode.model.System;
import com.rccode.model.User;

import java.util.List;

public class SystemRepositoryImpl implements SystemRepository {
    private System system;

    public SystemRepositoryImpl() {
        this.system = new System();
    }

    @Override
    public User getUserByMobile(String mobile) {
        for (User user : system.getUsers()) {
            if (user.getPhoneNumber().equals(mobile)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        system.getUsers().add(user);
    }

    @Override
    public void loginUser(User user) {
        system.setCurrentUser(user);
    }

    @Override
    public User getLogedInUser() {
        User user = system.getCurrentUser();
        if (user == null) {
            throw new ProcessException("Get LoggedIn User", "No user logged in");
        }
        return user;
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : system.getRestaurants()) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        system.getRestaurants().add(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return system.getRestaurants();
    }


}