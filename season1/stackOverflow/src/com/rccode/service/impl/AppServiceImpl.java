package com.rccode.service.impl;

import com.rccode.dto.*;
import com.rccode.exception.ProcessException;
import com.rccode.model.Question;
import com.rccode.model.User;
import com.rccode.repository.SystemRepository;
import com.rccode.repository.SystemRepositoryImpl;
import com.rccode.service.AppService;
import com.rccode.service.CacheService;
import com.rccode.service.QuestionService;
import com.rccode.service.UserService;

public class AppServiceImpl implements AppService {

    private UserService userService;
    private QuestionService questionService;
    private CacheService cacheService;
    private SystemRepository repository;

    public AppServiceImpl() {
        this.cacheService = new CacheServiceImpl();
        this.repository = new SystemRepositoryImpl();
        this.userService = new UserServiceImpl(this.cacheService, this.repository);
        this.questionService = new QuestionServiceImpl(this.cacheService, this.repository);
    }

    @Override
    public void signUpUser(AddUserRequest addUserRequest) {
        userService.addUser(addUserRequest);
        System.out.println("User signed up");
    }

    @Override
    public void subsribe(SubscribeRequest request) {
        userService.subscribe(request);
        System.out.println("Subscription updated");
    }

    @Override
    public void addQuestion(AddQuestionRequest request) {
        if (!repository.isUserLoggedIn()) {
            throw new ProcessException("Subscribe", "No user logged in");
        }
        User user = repository.getLoggedInUser();
        questionService.addQuestion(request, user);
        System.out.println("Question added");
    }

    @Override
    public void showFeed(ShowFeedRequest request) {
        questionService.showFeed(request);
    }

    @Override
    public void logout() {
        repository.logout();
    }

    @Override
    public void login(UserRequest request) {
        User user = userService.getUserByName(request.getName());
        if (user == null) {
            throw new ProcessException("Login", "User does not exists");
        }
        repository.login(user);
    }

    @Override
    public void showQuestion(ShowQuestionRequest request) {
        Question question = questionService.getQuestion(request.getQuestion());
        System.out.println(question.getQuestion());
    }

    @Override
    public void acceptAnswer(AnswerRequest request) {
        if (!repository.isUserLoggedIn()) {
            throw new ProcessException("Accept Answer", "No user logged in");
        }
        User user = repository.getLoggedInUser();
        questionService.acceptAnswer(request, user);
    }

    @Override
    public void upvoteAnswer(AnswerRequest request) {
        if (!repository.isUserLoggedIn()) {
            throw new ProcessException("Subscribe", "No user logged in");
        }
        User user = repository.getLoggedInUser();
        //questionService.upvote(request);
    }

    @Override
    public void showProfile(UserRequest request) {

    }

    @Override
    public void addAnswer(AnswerRequest request) {
        if (!repository.isUserLoggedIn()) {
            throw new ProcessException("Subscribe", "No user logged in");
        }
        User user = repository.getLoggedInUser();
        questionService.addAnswer(request, user);
    }
}
