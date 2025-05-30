package com.rccode;

import com.google.gson.Gson;
import com.rccode.enumeration.Command;
import com.rccode.enumeration.RoleType;
import com.rccode.service.CommandService;
import com.rccode.service.Controller;
import com.rccode.service.impl.ControllerImpl;
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
        Controller controller = new ControllerImpl();
        for (String commandStr : commands) {
            System.out.println("------------------------------------------");
            String[] commandParams = commandStr.split(",");
            try {
                Command command = Command.valueOf(commandParams[0].toUpperCase());
                switch (command) {
                    case CREATE_USER:
                        controller.createUser(commandParams[1]);
                        break;
                    case CREATE_DOCUMENT:
                        controller.createDocument(commandParams[1], commandParams[2], commandParams[3]);
                        break;
                    case READ_DOCUMENT:
                        controller.readDocument(commandParams[1], commandParams[2]);
                        break;
                    case EDIT_DOCUMENT:
                        controller.editDocument(commandParams[1], commandParams[2], commandParams[3]);
                        break;
                    case ADD_ROLE:
                        controller.addRole(commandParams[1], commandParams[2], commandParams[3], RoleType.valueOf(commandParams[4]));
                        break;
                    default:
                        System.out.println("Invalid Command");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
