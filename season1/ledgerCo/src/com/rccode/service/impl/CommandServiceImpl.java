package com.rccode.service.impl;

import com.rccode.service.CommandService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class CommandServiceImpl implements CommandService {

    @Override
    public List<String> processCommand(String filePath) {
        List<String> commands = new LinkedList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String commandLine;
            while((commandLine = bufferedReader.readLine()) != null) {
                commands.add(commandLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commands;
    }
}
