package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class System {
    private List<Question> questions;
    private User loggedInUser;
    private List<User> users;

    public System() {
        this.questions = new LinkedList<>();
        this.loggedInUser = null;
        this.users = new LinkedList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
