package com.rccode.service;

import com.rccode.dto.*;
import com.rccode.model.Restaurant;

public interface RestaurantService {
    void addRestautant(AddRestaurantRequest request);
    void placeOrder(PlaceOrderRequest request);
    void showRestaurant(ShowRestaurantRequest request);
    void updateLocation(UpdateLocationRequest request);
    void updateQuantity(UpdateQuantityRequest request);
    void addReview(CreateReviewRequest reviewRequest);
}
