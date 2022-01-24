package com.rccode.dto;

public class ShowQuestionRequest {
    private String question;

    public ShowQuestionRequest(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
