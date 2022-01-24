package com.rccode.repository;

import com.rccode.model.Restaurant;
import com.rccode.model.User;

import java.util.List;

public interface SystemRepository {
    User getUserByMobile(String mobile);
    void addUser(User user);
    void loginUser(User user);
    User getLogedInUser();
    Restaurant getRestaurantByName(String name);
    void addRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurants();
}
