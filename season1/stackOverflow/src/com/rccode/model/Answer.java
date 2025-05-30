package com.rccode.model;

import java.util.HashSet;
import java.util.Set;

public class Answer {
    private String answer;
    private User user;
    private Set<Upvote> upvotes;

    public Answer(String answer, User user) {
        this.answer = answer;
        this.user = user;
        this.upvotes = new HashSet<>();
    }

    public int getRating() {
        return upvotes.size();
    }
}
