package com.rccode.model;

public class ExpenseShare {
    int numberOfUsers;
    ExpenseData[][] expenseData;

    public ExpenseShare(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
        expenseData = new ExpenseData[numberOfUsers][numberOfUsers];
        for (int i = 0; i < numberOfUsers; i++) {
            for (int j = 0; j < numberOfUsers; j++) {
                expenseData[i][j] = new ExpenseData();
            }
        }
    }

    public boolean isValidUserId(int userId) {
        if (userId < 0 || userId > numberOfUsers) {
            return false;
        }
        return true;
    }

    public void updateAmount(int from, int to, double amount) {
        if (amount >= 0) {
            expenseData[from][to].setAmount(amount);
        }
    }

    public double getAmountDue(int from, int to) {
        return expenseData[from][to].getAmount();
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }
}
