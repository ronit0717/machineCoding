package com.rccode.repository;

import com.rccode.model.Question;
import com.rccode.model.System;
import com.rccode.model.User;

public interface SystemRepository {
    User getUserByName(String name);
    void addUser(User user);
    boolean isUserLoggedIn();
    User getLoggedInUser();
    void logout();
    void login(User user);
    void addQuestion(Question question);
    Question getQuestion(String param);
    System getSystem();
}
