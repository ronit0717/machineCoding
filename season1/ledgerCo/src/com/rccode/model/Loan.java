package com.rccode.model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Loan {
    private double principle;
    private double rate;
    private int timeInYears;
    private int emi;
    private Set<LumpSumAmount> payments;
    private Customer customer;

    public Loan(Customer customer, double principle, double rate, int timeInYears, int emi) {
        this.principle = principle;
        this.rate = rate;
        this.timeInYears = timeInYears;
        this.customer = customer;
        this.emi = emi;
        this.payments = new TreeSet<>(Comparator.comparingInt(LumpSumAmount::getEmiNumber));
    }

    public double getPrinciple() {
        return principle;
    }

    public double getRate() {
        return rate;
    }

    public int getTimeInYears() {
        return timeInYears;
    }

    public int getEmi() {
        return emi;
    }

    public Set<LumpSumAmount> getPayments() {
        return payments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addLumpSumPayment(LumpSumAmount lumpSumAmount) {
        payments.add(lumpSumAmount);
    }
}
