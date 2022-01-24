package com.rccode.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private String name;
    private Map<Customer, Loan> customerLoans;

    public Bank(String name) {
        this.name = name;
        customerLoans = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Customer, Loan> getCustomerLoans() {
        return customerLoans;
    }

    public void addLoan(Customer customer, Loan loan) {
        customerLoans.put(customer, loan);
    }
}
