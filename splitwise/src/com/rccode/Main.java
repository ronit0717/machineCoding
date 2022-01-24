package com.rccode;

import com.rccode.enumeration.Command;
import com.rccode.service.CommandService;
import com.rccode.service.SplitwiseService;
import com.rccode.service.impl.FileReaderServiceImpl;
import com.rccode.service.impl.ScannerServiceImpl;
import com.rccode.service.impl.SplitwiseServiceImpl;

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
        SplitwiseService service = new SplitwiseServiceImpl(4);
        for (String commandStr : commands) {
            System.out.println("------------------------------------------");
            String[] commandParams = commandStr.split("\\s");
            try {
                Command command = Command.valueOf(commandParams[0].toUpperCase());
                switch (command) {
                    case EXPENSE:
                        service.updateExpense(commandParams);
                        break;
                    case SHOW:
                        service.showExpense(commandParams);
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
