package com.rccode.service.impl;

import com.rccode.enumeration.Command;
import com.rccode.exception.ProcessException;
import com.rccode.model.Customer;
import com.rccode.repository.LedgerCoRepository;
import com.rccode.repository.LedgerCoRepositoryImpl;
import com.rccode.service.*;

public class LedgerServiceImpl implements LedgerService {

    private BankService bankService;
    private CustomerService customerService;

    public LedgerServiceImpl() {
        CacheService cacheService = new CacheServiceImpl();
        LedgerCoRepository repository = new LedgerCoRepositoryImpl();
        bankService = new BankServiceImpl(repository, cacheService);
        customerService = new CustomerServiceImpl(repository, cacheService);
    }

    @Override
    public void processCommand(String commandStr) {
        String[] commandParams = commandStr.split("\\s");
        try {
            Command command = Command.valueOf(commandParams[0].toUpperCase());
            switch (command) {
                case LOAN:
                    addLoan(commandParams[1], commandParams[2], Double.parseDouble(commandParams[3]),
                            Integer.parseInt(commandParams[4]), Integer.parseInt(commandParams[5]));
                    break;
                case PAYMENT:
                    addLumpsumPayment(commandParams[1], commandParams[2], Integer.parseInt(commandParams[3]), Integer.parseInt(commandParams[4]));
                    break;
                case BALANCE:
                    checkBalance(commandParams[1], commandParams[2], Integer.parseInt(commandParams[3]));
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addLoan(String bankName, String customerName, double principle, int timeInYears, int interestRate) {
        Customer customer = customerService.addCustomer(customerName);
        bankService.addLoan(bankName, customer, principle, interestRate, timeInYears);
    }

    @Override
    public void addLumpsumPayment(String bankName, String customerName, double lumpSumAmount, int emiNumber) {
        Customer customer = customerService.getCustomerByName(customerName);
        if (customer == null) {
            throw new ProcessException("Add Lump Sum Amount", "Customer does not exists");
        }
        bankService.addLumpSumAmount(bankName, customer, lumpSumAmount, emiNumber);
    }

    @Override
    public void checkBalance(String bankName, String customerName, int emiNumber) {
        Customer customer = customerService.getCustomerByName(customerName);
        if (customer == null) {
            throw new ProcessException("Add Lump Sum Amount", "Customer does not exists");
        }
        bankService.checkBalance(bankName, customer, emiNumber);
    }


}
