package com.rccode.service.impl;

import com.rccode.exception.ProcessException;
import com.rccode.model.User;
import com.rccode.repository.RepositoryService;
import com.rccode.service.CacheService;
import com.rccode.service.UserService;

public class UserServiceImpl implements UserService {

    private CacheService cacheService;
    private RepositoryService repositoryService;

    public UserServiceImpl(CacheService cacheService, RepositoryService repositoryService) {
        this.cacheService = cacheService;
        this.repositoryService = repositoryService;
    }

    @Override
    public User addUser(String userName) {
        User existingUser = repositoryService.getUserByName(userName);
        if (existingUser != null) {
            throw new ProcessException("Add User", "User already exists");
        }
        User user = new User(userName);
        repositoryService.addUser(user);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = repositoryService.getUserByName(name);
        if (user == null) {
            throw new ProcessException("Get User", "User does not exist");
        }
        return user;
    }
}
