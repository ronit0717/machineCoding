package com.rccode.service.impl;

import com.rccode.exception.ProcessException;
import com.rccode.model.Bank;
import com.rccode.model.Customer;
import com.rccode.model.Loan;
import com.rccode.model.LumpSumAmount;
import com.rccode.repository.LedgerCoRepository;
import com.rccode.service.BankLoanService;
import com.rccode.service.BankService;
import com.rccode.service.CacheService;

public class BankServiceImpl implements BankService {

    private LedgerCoRepository repository;
    private CacheService cacheService;
    private BankLoanService bankLoanService;

    private static final String CACHE_PREFIX = "bank_";
    private static final String SPACE = " ";

    public BankServiceImpl(LedgerCoRepository repository, CacheService cacheService) {
        this.repository = repository;
        this.cacheService = cacheService;
        this.bankLoanService = new BankLoanServiceImpl();
    }

    /**
     * Adds a new loan for a customer in a given bank
     * @param bankName: Name of the bank
     * @param customer: Customer object
     * @param principle: The principal amount
     * @param rate: The rate of interest
     * @param timeInYears: Time in years for loan repayment
     */
    @Override
    public void addLoan(String bankName, Customer customer, double principle, double rate, int timeInYears) {
        Bank bank = addBank(bankName);
        Loan loan = bank.getCustomerLoans().get(customer);
        if (loan != null) {
            throw new ProcessException("Add Loan", "Loan already exists for customer, new loan not allowed");
        }
        int emi = bankLoanService.computeEmi(principle, rate, timeInYears);
        loan = new Loan(customer, principle, rate, timeInYears, emi);
        bank.addLoan(customer, loan);
    }

    /**
     * Adds a lump sum amount to the existing EMIs paid
     * @param bankName: Name of the bank
     * @param customer: Customer object
     * @param amount: Lump Sum Amount paid
     * @param emiNumber: The EMI number for which the lump sum amount was paid
     */
    @Override
    public void addLumpSumAmount(String bankName, Customer customer, double amount, int emiNumber) {
        Bank bank = getBankByName(bankName);
        if (bank == null) {
            throw new ProcessException("Add Lump Sum Amount", "Invalid bank name/ Bank name doesn't exist");
        }
        Loan loan = bank.getCustomerLoans().get(customer);
        if (loan == null) {
            throw new ProcessException("Add Lump Sum Amount", "Loan doesn't exist for the customer");
        }
        LumpSumAmount lumpSumAmount = new LumpSumAmount(amount, emiNumber);
        loan.addLumpSumPayment(lumpSumAmount);
        bank.addLoan(customer, loan);
    }

    /**
     * Prints the amount paid till date and the number of EMIs remaining for a customer
     * @param bankName : name of the bank
     * @param customer : Customer object
     * @param emiNumber : number of EMIs paid
     */
    @Override
    public void checkBalance(String bankName, Customer customer, int emiNumber) {
        Bank bank = getBankByName(bankName);
        if (bank == null) {
            throw new ProcessException("Add Lump Sum Amount", "Invalid bank name/ Bank name doesn't exist");
        }
        Loan loan = bank.getCustomerLoans().get(customer);
        if (loan == null) {
            throw new ProcessException("Add Lump Sum Amount", "Loan doesn't exist for the customer");
        }
        double amountPaid = bankLoanService.getAmountPaid(loan, emiNumber);
        int emiCountRemaining = bankLoanService.getRemainingEmiCount(loan, emiNumber);
        String message = new StringBuilder(bankName).append(SPACE)
                                    .append(customer.getName()).append(SPACE)
                                    .append((int)Math.ceil(amountPaid)).append(SPACE)
                                    .append(emiCountRemaining).toString();
        System.out.println(message);
    }

    /**
     * Adds a new Bank with a given bankName, if not it already exists
     * @param bankName: Name of the bank
     * @return the Bank object
     */
    @Override
    public Bank addBank(String bankName) {
        Bank bank = getBankByName(bankName);
        if (bank != null) {
            return bank;
        }
        bank = new Bank(bankName);
        repository.addBank(bank);
        return bank;
    }

    /**
     * Returns the bank object based on bankName. First check is done in cache level, if not found, then repository is checked
     * @param bankName: Name of thr bank
     * @return the Bank object
     */
    @Override
    public Bank getBankByName(String bankName) {
        String key = CACHE_PREFIX + bankName.toLowerCase();
        Bank bank;

        try {
            bank = (Bank)cacheService.get(key);
            if (bank != null) {
                return bank;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        bank = repository.getBankByName(bankName);
        if (bank == null) {
            return null;
        }
        cacheService.put(key, bank);
        return bank;
    }
}
