package com.rccode;

import com.rccode.constant.AppConstants;
import com.rccode.model.Flipkar;
import com.rccode.service.FlipkarService;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Flipkar flipkar;
    private static FlipkarService service;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Flipkar Application Started, please enter command\n");

        flipkar = new Flipkar(new LinkedList<>(), "3rd Aug", 0);
        service = new FlipkarService(flipkar);

        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            System.out.println();
            if (command.equals(AppConstants.EXIT_COMMAND)) {
                break;
            }
            processCommand(command);
            System.out.println();
        }

        System.out.println("Terminating Flipkar Application");
    }

    private static void processCommand(String command) {
        try {
            if (command.indexOf(AppConstants.ADD_BRANCH_COMMAND) == 0) {
                service.addBranch(command.substring(AppConstants.ADD_BRANCH_COMMAND.length() + 1, command.length() - 1));
            } else if (command.indexOf(AppConstants.ADD_VEHICLE) == 0) {
                service.addVehicle(command.substring(AppConstants.ADD_VEHICLE.length() + 1, command.length() - 1));
            } else if (command.indexOf(AppConstants.RENT_VEHICLE) == 0) {
                service.rentVehicle(command.substring(AppConstants.RENT_VEHICLE.length() + 1, command.length() - 1));
            } else if (command.indexOf(AppConstants.GET_AVAILABLE_VEHICLE) == 0) {
                service.getAvailableVehicles(command.substring(AppConstants.GET_AVAILABLE_VEHICLE.length() + 1, command.length() - 1));
            } else if (command.indexOf(AppConstants.PRINT_SYSTEM_VIEW) == 0) {
                service.printSystemView(command.substring(AppConstants.PRINT_SYSTEM_VIEW.length() + 1, command.length() - 1));
            } else {
                System.out.println(AppConstants.INVALID_COMMAND_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppConstants.INVALID_COMMAND_MESSAGE);
        }
    }
}
