package com.rccode.dto;

import java.util.List;

public class AddQuestionRequest {
    private String question;
    private List<String> topics;

    public AddQuestionRequest(String question, List<String> topics) {
        this.question = question;
        this.topics = topics;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getTopics() {
        return topics;
    }
}