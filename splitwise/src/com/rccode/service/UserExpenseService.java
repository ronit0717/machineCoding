package com.rccode.service;

public interface UserExpenseService {
    void showExpenseForAllUsers();
    void showExpenseForUser(String userName);
    void updateExpense(String fromUserName, String toUserName, double amount);
}
