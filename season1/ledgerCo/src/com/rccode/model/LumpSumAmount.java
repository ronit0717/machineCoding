package com.rccode.model;

public class LumpSumAmount {
    private double amount;
    private int emiNumber;

    public LumpSumAmount(double amount, int emiNumber) {
        this.amount = amount;
        this.emiNumber = emiNumber;
    }

    public double getAmount() {
        return amount;
    }

    public int getEmiNumber() {
        return emiNumber;
    }
}
