package com.rccode.service.impl;

import com.rccode.dto.AddQuestionRequest;
import com.rccode.dto.AnswerRequest;
import com.rccode.dto.ShowFeedRequest;
import com.rccode.exception.ProcessException;
import com.rccode.model.Answer;
import com.rccode.model.Question;
import com.rccode.model.Topic;
import com.rccode.model.User;
import com.rccode.repository.SystemRepository;
import com.rccode.service.CacheService;
import com.rccode.service.QuestionService;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private CacheService cacheService;
    private SystemRepository repository;

    private final String QUESTION_KEY_PREFIX = "Q_";

    public QuestionServiceImpl(CacheService cacheService, SystemRepository systemRepository) {
        this.cacheService = cacheService;
        this.repository = systemRepository;
    }

    @Override
    public void addQuestion(AddQuestionRequest request, User user) {
        Question question = new Question(request, user);
        repository.addQuestion(question);
    }

    @Override
    public Question getQuestion(String questionParam) {
        String key = QUESTION_KEY_PREFIX + questionParam;
        Question question = (Question) cacheService.get(key);
        if (question == null) {
            question = repository.getQuestion(questionParam);
            if (question == null) {
                return null;
            }
            cacheService.put(key, question);
        }
        return question;
    }

    @Override
    public void addAnswer(AnswerRequest answerRequest, User user) {
        Question question = getQuestion(answerRequest.getQuestion());
        if (question == null) {
            throw new ProcessException("Add Answer", "Question not found");
        }
        Answer answer = new Answer(answerRequest.getAnswer(), user);
        question.addAnswer(answer);
    }

    @Override
    public void showFeed(ShowFeedRequest request) {
        List<Question> questions = repository.getSystem().getQuestions();
        List<Question> filteredQuestions = new LinkedList<>(questions);
        if (request.getFilter() != null) {
            for (String filter : request.getFilter()) {
                for (Iterator<Question> q = filteredQuestions.iterator(); q.hasNext();) {
                    Question question = q.next();
                    boolean tagExists = false;
                    for (Topic topic : question.getTopics()) {
                        if (topic.getName().equals(filter)) {
                            tagExists = true;
                            break;
                        }
                    }
                    if (!tagExists) {
                        q.remove();
                    }
                }
            }
        }
        if (request.getAnswered() != null && request.getAnswered()) {
            for (Iterator<Question> q = filteredQuestions.iterator(); q.hasNext();) {
                Question question = q.next();
                if (!question.isAnswered()) {
                    q.remove();
                }
            }
        }
        printQuestions(filteredQuestions);
    }

    @Override
    public void acceptAnswer(AnswerRequest request, User user) {
        Question question = getQuestion(request.getQuestion());
        Answer answer = new Answer(request.getAnswer(), user);
        question.setAcceptedAnswer(answer);
    }

    @Override
    public void upvote(AnswerRequest request, User user) {

    }

    private void printQuestions(List<Question> questions) {
        for (Question  q : questions) {
            System.out.println(q.getQuestion());
        }
    }


}
