package com.rccode.service.impl;

import com.rccode.dto.AddUserRequest;
import com.rccode.exception.ProcessException;
import com.rccode.model.User;
import com.rccode.repository.SystemRepository;
import com.rccode.service.CacheService;
import com.rccode.service.UserService;

public class UserServiceImpl implements UserService {
    private CacheService cacheService;
    private SystemRepository repository;

    public UserServiceImpl(CacheService cacheService, SystemRepository systemRepository) {
        this.cacheService = cacheService;
        this.repository = systemRepository;
    }

    private final String USER_KEY_PREFIX = "U_";

    @Override
    public void addUser(AddUserRequest request) {
        User existingUser = getUserByMobile(request.getMobile());
        if (existingUser != null) {
            throw new ProcessException("Add User", "User already exists with given mobile number");
        }
        User user = new User(request);
        repository.addUser(user);
    }

    @Override
    public User getUserByMobile(String mobile) {
        String key = USER_KEY_PREFIX + mobile;
        User user = (User)cacheService.get(key);
        if (user == null) {
            user = repository.getUserByMobile(mobile);
            if (user == null) {
                return null;
            }
            cacheService.put(key, user);
        }
        return user;
    }
}
