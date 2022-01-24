package com.rccode.service;

import com.rccode.dto.AddQuestionRequest;
import com.rccode.dto.AnswerRequest;
import com.rccode.dto.ShowFeedRequest;
import com.rccode.model.Question;
import com.rccode.model.User;

public interface QuestionService {
    void addQuestion(AddQuestionRequest request, User user);
    Question getQuestion(String question);
    void addAnswer(AnswerRequest answerRequest, User user);
    void showFeed(ShowFeedRequest request);
    void acceptAnswer(AnswerRequest request, User user);
    void upvote(AnswerRequest request, User user);
}
