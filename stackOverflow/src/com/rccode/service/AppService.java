package com.rccode.service;

import com.rccode.dto.*;

public interface AppService {
    void signUpUser(AddUserRequest addUserRequest);
    void subsribe(SubscribeRequest request);
    void addQuestion(AddQuestionRequest request);
    void showFeed(ShowFeedRequest request);
    void logout();
    void login(UserRequest request);
    void showQuestion(ShowQuestionRequest request);
    void acceptAnswer(AnswerRequest request);
    void upvoteAnswer(AnswerRequest request);
    void showProfile(UserRequest request);
    void addAnswer(AnswerRequest request);
}
