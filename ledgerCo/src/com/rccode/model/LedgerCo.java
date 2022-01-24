package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class LedgerCo {
    private List<Bank> banks;
    private List<Customer> customers;

    public LedgerCo() {
        this.banks = new LinkedList<>();
        this.customers = new LinkedList<>();
    }

    public void addBank(Bank bank) {
        this.banks.add(bank);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Bank getBankByName(String name) {
        for (Bank bank : this.banks) {
            if (name.equals(bank.getName())) {
                return bank;
            }
        }
        return null;
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (name.equals(customer.getName())) {
                return customer;
            }
        }
        return null;
    }
}
