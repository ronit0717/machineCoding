package com.rccode.service.impl;

import com.rccode.enumeration.ExpenseType;
import com.rccode.exception.ProcessException;
import com.rccode.service.SplitwiseService;
import com.rccode.service.UserExpenseService;

public class SplitwiseServiceImpl implements SplitwiseService {

    private UserExpenseService expenseService;

    public SplitwiseServiceImpl(int numberOfUsers) {
        this.expenseService = new UserExpenseServiceImpl(numberOfUsers);
    }

    @Override
    public void showExpense(String[] args) {
        if (args == null || args.length <= 0 || args.length > 2) {
            throw new ProcessException("Show Expense", "Invalid Input");
        }
        if (args.length == 1) {
            expenseService.showExpenseForAllUsers();
        } else {
            String userName = args[1];
            expenseService.showExpenseForUser(userName);
        }
    }

    @Override
    public void updateExpense(String[] args) {
        if (args == null || args.length < 2) {
            throw new ProcessException("Update Expense", "Invalid Input");
        }

        try {
            String userName = args[1];
            double totalAmount = Double.parseDouble(args[2]);
            int splitCount = Integer.parseInt(args[3]);

            if (splitCount <= 0) {
                throw new ProcessException("Update Expense", "Minimum 1 user required to split the amount");
            }
            String[] splitUsers = new String[splitCount];
            for (int i = 0; i < splitCount; i++) {
                splitUsers[i] = args[4 + i];
            }
            ExpenseType expenseType = ExpenseType.valueOf(args[4 + splitCount]);

            int[] splitShare = new int[splitCount];
            if (!ExpenseType.EQUAL.equals(expenseType)) {
                for (int i = 0; i < splitCount; i++) {
                    splitShare[i] = Integer.parseInt(args[5 + splitCount + i]);
                }
            }

            boolean check = expenseType.checkValidArgs(splitShare, totalAmount);
            if (!check) {
                throw new ProcessException("Update Expense", "Invalid share");
            }

            for (int i = 0; i < splitCount; i++) {
                if (userName.equals(splitUsers[i])) {
                    continue;
                }
                double split = expenseType.getShare(totalAmount, splitShare, i);
                expenseService.updateExpense(userName, splitUsers[i], split);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ProcessException("Update Expense", "Invalid Input");
        }

    }
}
