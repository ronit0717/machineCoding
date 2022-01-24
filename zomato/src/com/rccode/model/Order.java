package com.rccode.model;

public class Order {
    private User user;
    private Food food;
    private int quantity;

    public Order(User user, Food food, int quantity) {
        this.user = user;
        this.food = food;
        this.quantity = quantity;
    }
}
