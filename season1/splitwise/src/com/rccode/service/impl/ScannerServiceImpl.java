package com.rccode.service.impl;

import com.rccode.constant.AppConstant;
import com.rccode.service.CommandService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScannerServiceImpl implements CommandService {

    @Override
    public List<String> readCommands(String filePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands...");
        List<String> commands = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            System.out.println();
            if (command.equals(AppConstant.EXIT_COMMAND)) {
                break;
            }
            commands.add(command);
        }
        scanner.close();
        return commands;
    }

}
