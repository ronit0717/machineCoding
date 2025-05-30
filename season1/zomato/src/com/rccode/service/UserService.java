package com.rccode.service;

import com.rccode.dto.AddUserRequest;
import com.rccode.model.User;

public interface UserService {
    void addUser(AddUserRequest request);
    User getUserByMobile(String mobile);
}
