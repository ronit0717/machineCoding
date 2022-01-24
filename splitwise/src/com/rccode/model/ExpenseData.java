package com.rccode.model;

public class ExpenseData {
    private double amount;

    public ExpenseData() {
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(double deltaAmount) {
        this.amount = this.amount + deltaAmount;
    }

    public void decreaseAmount(double deltaAmount) {
        this.amount = (deltaAmount > this.amount) ? 0 : this.amount - deltaAmount;
    }
}
