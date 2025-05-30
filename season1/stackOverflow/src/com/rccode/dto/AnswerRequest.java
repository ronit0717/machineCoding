package com.rccode.dto;

public class AnswerRequest {
    private String question;
    private String answer;

    public AnswerRequest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
