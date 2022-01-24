package com.rccode;

import com.google.gson.Gson;
import com.rccode.dto.*;
import com.rccode.service.CommandService;
import com.rccode.service.SystemService;
import com.rccode.service.impl.FileReaderServiceImpl;
import com.rccode.service.impl.ScannerServiceImpl;
import com.rccode.service.impl.SystemServiceImpl;

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

        SystemService service = new SystemServiceImpl();

        for (String commandStr : commands) {
            System.out.println();
            try {
                CommandRequest commandRequest = new Gson().fromJson(commandStr, CommandRequest.class);
                Object request = commandRequest.getCommandRequest();
                switch(commandRequest.getCommand()) {
                    case REGISTER_USER:
                        service.registerUser((AddUserRequest) request);
                        break;
                    case REGISTER_RESTAURANT:
                        service.registerRestaurant((AddRestaurantRequest) request);
                        break;
                    case CREATE_REVIEW:
                        service.createReview((CreateReviewRequest) request);
                        break;
                    case PLACE_ORDER:
                        service.placeOrder((PlaceOrderRequest) request);
                        break;
                    case SHOW_RESTAURANT:
                        service.showRestaurant((ShowRestaurantRequest) request);
                        break;
                    case UPDATE_LOCATION:
                        service.updateLocation((UpdateLocationRequest) request);
                        break;
                    case UPDATE_QUANTITY:
                        service.updateQuantity((UpdateQuantityRequest) request);
                        break;
                    case LOGIN_USER:
                        service.loginUser((UserLoginRequest) request);
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
