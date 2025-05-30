package com.rccode;

import com.google.gson.Gson;
import com.rccode.dto.*;
import com.rccode.service.AppService;
import com.rccode.service.CommandService;
import com.rccode.service.impl.AppServiceImpl;
import com.rccode.service.impl.FileReaderServiceImpl;
import com.rccode.service.impl.ScannerServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Application started...");

        CommandService commandService;
        String filePath = null;
        if (args == null || args.length == 0) {
            commandService = new ScannerServiceImpl();
        } else {
            filePath = args[0];
            commandService = new FileReaderServiceImpl();
        }

        List<String> commands = commandService.readCommands(filePath);
        processCommands(commands);

        System.out.println("Application terminated...");
    }

    private static void processCommands(List<String> commands) {
        AppService service = new AppServiceImpl();
        for (String commandStr : commands) {
            System.out.println("------------------------------------------");
            try {
                CommandRequest commandRequest = new Gson().fromJson(commandStr, CommandRequest.class);
                Object request = commandRequest.getCommandRequest();
                switch(commandRequest.getCommand()) {
                    case USER_SIGNUP:
                        service.signUpUser((AddUserRequest) request);
                        break;
                    case SUBSCRIBE:
                        service.subsribe((SubscribeRequest) request);
                        break;
                    case ADD_QUESTION:
                        service.addQuestion((AddQuestionRequest) request);
                        break;
                    case SHOW_FEED:
                        service.showFeed((ShowFeedRequest) request);
                        break;
                    case LOGOUT:
                        service.logout();
                        break;
                    case LOGIN:
                        service.login((UserRequest) request);
                        break;
                    case SHOW_QUESTION:
                        service.showQuestion((ShowQuestionRequest) request);
                        break;
                    case UPVOTE_ANSWER:
                        service.upvoteAnswer((AnswerRequest) request);
                        break;
                    case ACCEPT_ANSWER:
                        service.acceptAnswer((AnswerRequest) request);
                        break;
                    case SHOW_PROFILE:
                        service.showProfile((UserRequest) request);
                        break;
                    case ADD_ANSWER:
                        service.addAnswer((AnswerRequest) request);
                        break;
                    default:
                        System.out.println("Error: Invalid Request");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid command");
                e.printStackTrace();
            }
        }
    }

}
