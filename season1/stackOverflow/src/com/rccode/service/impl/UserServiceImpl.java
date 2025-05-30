package com.rccode.service.impl;

import com.rccode.dto.AddUserRequest;
import com.rccode.dto.SubscribeRequest;
import com.rccode.exception.ProcessException;
import com.rccode.model.Topic;
import com.rccode.model.User;
import com.rccode.repository.SystemRepository;
import com.rccode.service.CacheService;
import com.rccode.service.UserService;

import java.util.LinkedList;
import java.util.List;

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
        User existingUser = getUserByName(request.getName());
        if (existingUser != null) {
            throw new ProcessException("Add User", "User already exists with given name");
        }
        User user = new User(request);
        repository.addUser(user);
        repository.login(user);
    }

    @Override
    public User getUserByName(String name) {
        String key = USER_KEY_PREFIX + name;
        User user = (User)cacheService.get(key);
        if (user == null) {
            user = repository.getUserByName(name);
            if (user == null) {
                return null;
            }
            cacheService.put(key, user);
        }
        return user;
    }

    @Override
    public void subscribe(SubscribeRequest request) {
        if (!repository.isUserLoggedIn()) {
            throw new ProcessException("Subscribe", "No user logged in");
        }
        User user = repository.getLoggedInUser();
        List<Topic> topics = new LinkedList<>();
        for (String topic : request.getTopics()) {
            topics.add(new Topic(topic));
        }
        user.subscribeTopics(topics);
    }
}
