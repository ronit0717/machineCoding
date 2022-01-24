package com.rccode.service;

import com.rccode.dto.AddUserRequest;
import com.rccode.dto.SubscribeRequest;
import com.rccode.model.User;

public interface UserService {
    void addUser(AddUserRequest request);
    User getUserByName(String name);
    void subscribe(SubscribeRequest request);
}
