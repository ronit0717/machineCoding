package com.rccode.repository;

import com.rccode.model.Question;
import com.rccode.model.System;
import com.rccode.model.User;

public class SystemRepositoryImpl implements SystemRepository {

    private System system;

    public SystemRepositoryImpl() {
        this.system = new System();
    }

    @Override
    public User getUserByName(String name) {
        for (User user : system.getUsers()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        system.getUsers().add(user);
    }

    @Override
    public boolean isUserLoggedIn() {
        return system.getLoggedInUser() != null;
    }

    @Override
    public User getLoggedInUser() {
        return system.getLoggedInUser();
    }

    @Override
    public void logout() {
        system.setLoggedInUser(null);
    }

    @Override
    public void login(User user) {
        system.setLoggedInUser(user);
    }

    @Override
    public void addQuestion(Question question) {
        system.addQuestion(question);
    }

    @Override
    public Question getQuestion(String param) {
        for (Question question : system.getQuestions()) {
            if (question.getQuestion().equals(param)) {
                return question;
            }
        }
        return null;
    }

    @Override
    public System getSystem() {
        return this.system;
    }
}
