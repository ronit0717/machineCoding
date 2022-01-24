package com.rccode.repository;

import com.rccode.exception.ProcessException;
import com.rccode.model.ExpenseShare;

public class ExpenseRepositoryImpl implements ExpenseRepository {

    private ExpenseShare expenseShare;

    public ExpenseRepositoryImpl(int numberOfUsers) {
        this.expenseShare = new ExpenseShare(numberOfUsers);
    }

    @Override
    public void updateExpense(int fromUser, int toUser, double amount) {
        if (fromUser == toUser) {
            return;
        }
        if (!expenseShare.isValidUserId(fromUser) || !expenseShare.isValidUserId(toUser)) {
            throw new ProcessException("Update Expense", "Invalid User ID");
        }
        if (amount < 0) {
            throw new ProcessException("Update Expense", "Invalid Amount");
        }
        expenseShare.updateAmount(fromUser, toUser, amount);
    }

    @Override
    public double getAmountDue(int fromUser, int toUser) {
        if (!expenseShare.isValidUserId(fromUser) || !expenseShare.isValidUserId(toUser)) {
            throw new ProcessException("Get Amount Due", "Invalid User ID");
        }
        return expenseShare.getAmountDue(fromUser, toUser);
    }

    @Override
    public int getNumberOfUsers() {
        return expenseShare.getNumberOfUsers();
    }
}
