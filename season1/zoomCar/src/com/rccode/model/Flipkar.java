package com.rccode.model;

import java.util.List;

public class Flipkar {

    List<Branch> branchList;
    private String currentDate;
    private int currentTimeSlot;

    public Flipkar(List<Branch> branchList, String currentDate, int currentTimeSlot) {
        this.branchList = branchList;
        this.currentDate = currentDate;
        this.currentTimeSlot = currentTimeSlot;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getCurrentTimeSlot() {
        return currentTimeSlot;
    }

    public void setCurrentTimeSlot(int currentTimeSlot) {
        this.currentTimeSlot = currentTimeSlot;
    }
}
