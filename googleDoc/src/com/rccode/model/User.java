package com.rccode.model;

import com.rccode.service.util.RandomUtil;

public class User {
    private String id;
    private String name;

    public User(String name) {
        this.id = RandomUtil.getRandomId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
