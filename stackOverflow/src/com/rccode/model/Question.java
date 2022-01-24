package com.rccode.model;

import com.rccode.dto.AddQuestionRequest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question {
    private String question;
    private List<Topic> topics;
    private List<Answer> answers;
    private User user;
    private Set<Upvote> upvotes;
    private Answer acceptedAnswer;

    public Question(AddQuestionRequest request, User user) {
        this.question = request.getQuestion();
        List<Topic> topics = new LinkedList<>();
        for (String topic : request.getTopics()) {
            topics.add(new Topic(topic));
        }
        this.topics = topics;
        this.answers = new LinkedList<>();
        this.upvotes = new HashSet<>();
        this.user = user;
        this.acceptedAnswer = null;
    }

    public int getRating() {
        return upvotes.size();
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswered() {
        return this.acceptedAnswer != null;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }
}
