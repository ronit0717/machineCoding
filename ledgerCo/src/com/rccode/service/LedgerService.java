package com.rccode.service;

public interface LedgerService {
    void processCommand(String command);
    void addLoan(String bankName, String customerName, double principle, int timeInYears, int interestRate);
    void addLumpsumPayment(String bankName, String customerName, double lumpSumAmount, int emiNumber);
    void checkBalance(String bankName, String customerName, int emiNumber);
}
