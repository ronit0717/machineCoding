package com.rccode.dto;

public class GetAvailableVehicleRequest {
    private String branchName;
    private String startTime;
    private String endTime;

    public GetAvailableVehicleRequest(String branchName, String startTime, String endTime) {
        this.branchName = branchName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
