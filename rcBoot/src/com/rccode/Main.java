package com.rccode;

import com.google.gson.Gson;
import com.rccode.service.CommandService;
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
        for (String commandStr : commands) {
            System.out.println("------------------------------------------");
            String[] commandParams = commandStr.split("\\s");
            try {
            /*
            Command command = Command.valueOf(commandParams[0].toUpperCase());
            switch (command) {
                case SOMETHING:
                    someService.someMethod(commandParams[1], commandParams[2], Double.parseDouble(commandParams[3]),
                            Integer.parseInt(commandParams[4]), Integer.parseInt(commandParams[5]));
                    break;
                case SOMETHING_ELSE:
                    someService.someOtherMethod(args...);
                    break;
                default:
                    System.out.println("Invalid Command");
            }
            */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    private static void processCommands(List<String> commands) {

        FlipkarService service = new FlipkarServiceImpl();

        for (String commandStr : commands) {
            System.out.println("------------------------------------------");
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
                        service.getAvailableVehicles((GetAvailableVehicleRequest)request);
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
    */

}
