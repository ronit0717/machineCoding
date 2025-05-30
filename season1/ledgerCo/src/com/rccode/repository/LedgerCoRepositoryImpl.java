package com.rccode.repository;

import com.rccode.model.Bank;
import com.rccode.model.Customer;
import com.rccode.model.LedgerCo;

public class LedgerCoRepositoryImpl implements LedgerCoRepository {
    private LedgerCo ledgerCo;

    public LedgerCoRepositoryImpl() {
        this.ledgerCo = new LedgerCo();
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return ledgerCo.getCustomerByName(customerName);
    }

    @Override
    public void addCustomer(Customer customer) {
        ledgerCo.addCustomer(customer);
    }

    @Override
    public Bank getBankByName(String bankName) {
        return ledgerCo.getBankByName(bankName);
    }

    @Override
    public void addBank(Bank bank) {
        ledgerCo.addBank(bank);
    }
}
