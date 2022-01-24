package com.rccode;


import com.google.gson.Gson;
import com.rccode.dto.*;
import com.rccode.service.CommandService;
import com.rccode.service.FlipkarService;
import com.rccode.service.impl.FileReaderServiceImpl;
import com.rccode.service.impl.FlipkarServiceImpl;
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

        FlipkarService service = new FlipkarServiceImpl();

        for (String commandStr : commands) {
            System.out.println();
            try {
                CommandRequest commandRequest = new Gson().fromJson(commandStr, CommandRequest.class);
                Object request = commandRequest.getCommandRequest();
                switch(commandRequest.getCommand()) {
                    case ADD_BRANCH:
                        service.addBranch((AddBranchRequest)request);
                        break;
                    case ADD_VEHICLE:
                        service.addVehicle((AddVehicleRequest)request);
                        break;
                    case GET_AVAILABLE_VEHICLE:
                        service.printAvailableVehicles((GetAvailableVehicleRequest)request);
                        break;
                    case RENT_VEHICLE:
                        service.rentVehicle((RentVehicleRequest)request);
                        break;
                    case PRINT_SYSTEM_VIEW:
                        service.printSystemView((PrintSystemViewRequest)request);
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
