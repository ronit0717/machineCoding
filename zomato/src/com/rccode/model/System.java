package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class System {
    private User currentUser;
    private List<User> users;
    private List<Restaurant> restaurants;

    public System() {
        this.currentUser = null;
        this.users = new LinkedList<>();
        this.restaurants = new LinkedList<>();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}