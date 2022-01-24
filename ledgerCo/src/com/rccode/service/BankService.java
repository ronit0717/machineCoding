package com.rccode.service;

import com.rccode.model.Bank;
import com.rccode.model.Customer;

public interface BankService {
    void addLoan(String bankName, Customer customer, double principle, double rate, int timeInYears);
    void addLumpSumAmount(String bankName, Customer customer, double amount, int emiNumber);
    void checkBalance(String bankName, Customer customer, int emiNumber);
    Bank addBank(String bankName);
    Bank getBankByName(String bankName);
}
