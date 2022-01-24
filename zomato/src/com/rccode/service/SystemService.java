package com.rccode.service;

import com.rccode.dto.*;

public interface SystemService {
    void registerRestaurant(AddRestaurantRequest restaurantRequest);
    void loginUser(UserLoginRequest request);
    void registerUser(AddUserRequest addUserRequest);
    void createReview(CreateReviewRequest createReviewRequest);
    void placeOrder(PlaceOrderRequest placeOrderRequest);
    void showRestaurant(ShowRestaurantRequest showRestaurantRequest);
    void updateLocation(UpdateLocationRequest updateLocationRequest);
    void updateQuantity(UpdateQuantityRequest updateQuantityRequest);
}
