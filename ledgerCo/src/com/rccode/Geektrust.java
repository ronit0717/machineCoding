package com.rccode;

import com.rccode.service.CommandService;
import com.rccode.service.LedgerService;
import com.rccode.service.impl.CommandServiceImpl;
import com.rccode.service.impl.LedgerServiceImpl;

import java.util.List;

public class Geektrust {

    public static void main(String[] args) {
	    if (args == null || args.length == 0) {
            System.out.println("File Path not entered, aborting application");
            return;
        }
	    String filePath = args[0];

	    CommandService commandService = new CommandServiceImpl();
        List<String> commands = commandService.processCommand(filePath);

        LedgerService ledgerService = new LedgerServiceImpl();
        for (String command : commands) {
            ledgerService.processCommand(command);
        }
    }
}
