package com.rccode.service;

import com.rccode.model.Loan;

public interface BankLoanService {
    int computeEmi(double principle, double rate, int timeInYears);
    int getRemainingEmiCount(Loan loan, int currentEmiNumber);
    double getAmountPaid(Loan loan, int currentEmiNumber);
    double getBalanceAmount(Loan loan, int currentEmiNumber);
}
