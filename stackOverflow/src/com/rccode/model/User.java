package com.rccode.model;

import com.rccode.dto.AddUserRequest;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private String profession;
    private List<Topic> topicsSubsribed;

    public User(AddUserRequest request) {
        this.name = request.getName();
        this.profession = request.getProfession();
        this.topicsSubsribed = new LinkedList<>();
    }

    public void subscribeTopics(List<Topic> topics) {
        this.topicsSubsribed = topics;
    }

    public String getName() {
        return name;
    }
}
