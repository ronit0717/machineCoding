package com.rccode;

import com.google.gson.Gson;
import com.rccode.service.CommandService;
import com.rccode.service.GameService;
import com.rccode.service.impl.FileReaderServiceImpl;
import com.rccode.service.impl.GameServiceImpl;
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
        GameService gameService = new GameServiceImpl();
        gameService.printGame();
        for (String commandStr : commands) {
            System.out.println();
            String[] commandParams = commandStr.split("\\s");
            try {
                gameService.nextMove(commandParams[0], commandParams[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
