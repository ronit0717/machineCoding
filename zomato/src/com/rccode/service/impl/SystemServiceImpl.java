package com.rccode.service.impl;

import com.rccode.dto.*;
import com.rccode.exception.ProcessException;
import com.rccode.model.User;
import com.rccode.repository.SystemRepository;
import com.rccode.repository.SystemRepositoryImpl;
import com.rccode.service.CacheService;
import com.rccode.service.RestaurantService;
import com.rccode.service.SystemService;
import com.rccode.service.UserService;

public class SystemServiceImpl implements SystemService {

    private UserService userService;
    private RestaurantService restaurantService;
    private CacheService cacheService;
    private SystemRepository repository;

    public SystemServiceImpl() {
        this.cacheService = new CacheServiceImpl();
        this.repository = new SystemRepositoryImpl();
        this.userService = new UserServiceImpl(this.cacheService, this.repository);
        this.restaurantService = new RestaurantServiceImpl(this.cacheService, this.repository);
    }

    @Override
    public void registerRestaurant(AddRestaurantRequest restaurantRequest) {
        restaurantService.addRestautant(restaurantRequest);
    }

    @Override
    public void loginUser(UserLoginRequest request) {
        User user = userService.getUserByMobile(request.getMobile());
        if (user == null) {
            throw new ProcessException("User Login", "Invalid mobile number");
        }
        repository.loginUser(user);
    }

    @Override
    public void registerUser(AddUserRequest addUserRequest) {
        userService.addUser(addUserRequest);
    }

    @Override
    public void createReview(CreateReviewRequest createReviewRequest) {
        restaurantService.addReview(createReviewRequest);
    }

    @Override
    public void placeOrder(PlaceOrderRequest placeOrderRequest) {
        restaurantService.placeOrder(placeOrderRequest);
    }

    @Override
    public void showRestaurant(ShowRestaurantRequest showRestaurantRequest) {
        restaurantService.showRestaurant(showRestaurantRequest);
    }

    @Override
    public void updateLocation(UpdateLocationRequest updateLocationRequest) {
        restaurantService.updateLocation(updateLocationRequest);
    }

    @Override
    public void updateQuantity(UpdateQuantityRequest updateQuantityRequest) {
        restaurantService.updateQuantity(updateQuantityRequest);
    }
}
