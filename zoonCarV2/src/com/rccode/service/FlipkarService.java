package com.rccode.service;

import com.rccode.dto.*;
import com.rccode.model.Vehicle;

import java.util.Map;

public interface FlipkarService {
    void addBranch(AddBranchRequest request);
    void addVehicle(AddVehicleRequest request);
    void printAvailableVehicles(GetAvailableVehicleRequest request);
    Map<Vehicle, Integer> getAvailableVehicles(GetAvailableVehicleRequest request);
    void printSystemView(PrintSystemViewRequest request);
    void rentVehicle(RentVehicleRequest request);
}
