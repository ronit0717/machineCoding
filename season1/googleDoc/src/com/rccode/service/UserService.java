package com.rccode.service;

import com.rccode.model.User;

public interface UserService {
    User addUser(String userName);
    User getUserByName(String name);
}
