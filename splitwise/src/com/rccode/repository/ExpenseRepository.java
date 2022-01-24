package com.rccode.repository;

public interface ExpenseRepository {
    void updateExpense(int fromUser, int toUser, double amount);
    double getAmountDue(int fromUser, int toUser);
    int getNumberOfUsers();
}
