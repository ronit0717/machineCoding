package com.rccode.repository;

import com.rccode.model.Bank;
import com.rccode.model.Customer;

public interface LedgerCoRepository {
    Customer getCustomerByName(String customerName);
    void addCustomer(Customer customer);
    Bank getBankByName(String bankName);
    void addBank(Bank bank);
}
