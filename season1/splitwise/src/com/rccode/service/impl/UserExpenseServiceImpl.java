package com.rccode.service.impl;

import com.rccode.constant.AppConstant;
import com.rccode.repository.ExpenseRepository;
import com.rccode.repository.ExpenseRepositoryImpl;
import com.rccode.service.UserExpenseService;

public class UserExpenseServiceImpl implements UserExpenseService {

    private ExpenseRepository repository;

    public UserExpenseServiceImpl(int numberOfUsers) {
        this.repository = new ExpenseRepositoryImpl(numberOfUsers);
    }

    @Override
    public void showExpenseForAllUsers() {
        int numberOfUsers = repository.getNumberOfUsers();
        for (int i = 0; i < numberOfUsers; i++) {
            showExpenseForUser("U" + (i + 1));
        }
    }

    @Override
    public void showExpenseForUser(String userName) {
        int numberOfUsers = repository.getNumberOfUsers();
        int userId = getUserIdFromUserName(userName);
        boolean showedExpense = false;
        for (int i = 0; i < numberOfUsers; i++) {
            if (i == userId) {
                continue;
            }
            double due = repository.getAmountDue(userId, i);
            if (due > 0) {
                showedExpense = true;
                System.out.println("User" + (i + 1) + " owes User" + (userId + 1) + " : " + AppConstant.DF2.format(due));
            }
            double reverseDue = repository.getAmountDue(i, userId);
            if (reverseDue > 0) {
                showedExpense = true;
                System.out.println("User" + (userId + 1) + " owes User" + (i + 1) + " : " + AppConstant.DF2.format(reverseDue));
            }
        }
        if (!showedExpense) {
            System.out.println("No Balances");
        }
    }

    @Override
    public void updateExpense(String fromUserName, String toUserName, double amount) {
        if (amount < 0) {
            updateExpense(toUserName, fromUserName, Math.abs(amount));
        }
        int fromUserId = getUserIdFromUserName(fromUserName);
        int toUserId = getUserIdFromUserName(toUserName);

        //check if toUser owes anything to fromUser
        double due = repository.getAmountDue(fromUserId, toUserId);
        double reverseDue = repository.getAmountDue(toUserId, fromUserId);
        if (reverseDue > 0 && reverseDue >= amount) {
            repository.updateExpense(toUserId, fromUserId, reverseDue - amount);
        } else if (reverseDue > 0) {
            repository.updateExpense(toUserId, fromUserId, 0);
            repository.updateExpense(fromUserId, toUserId, due + amount - reverseDue);
        } else {
            repository.updateExpense(fromUserId, toUserId, due + amount);
        }
    }


    private int getUserIdFromUserName(String userName) {
        String userNum = userName.substring(1);
        return Integer.parseInt(userNum) - 1;
    }
}
