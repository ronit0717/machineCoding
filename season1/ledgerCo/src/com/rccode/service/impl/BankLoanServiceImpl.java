package com.rccode.service.impl;

import com.rccode.model.Loan;
import com.rccode.model.LumpSumAmount;
import com.rccode.service.BankLoanService;

public class BankLoanServiceImpl implements BankLoanService {

    private final int MONTHS_PER_YEAR = 12;

    /**
     * Computes the EMI for the given inputs
     * @param principle amount
     * @param rate of interest
     * @param timeInYears
     * @return the calculated EMI
     */
    @Override
    public int computeEmi(double principle, double rate, int timeInYears) {
        double totalAmount = getTotalLoanAmount(principle, rate, timeInYears);
        int totalMonths = MONTHS_PER_YEAR * timeInYears;
        double emi = totalAmount / totalMonths;
        return (int)Math.ceil(emi);
    }

    /**
     * Based on the currentEMINumber computes the balance and returns number of EMIs left
     * @param loan for which remaining EMI count needs to be computed
     * @param currentEmiNumber : current number of EMIs paid
     * @return number of EMIs remaining
     */
    @Override
    public int getRemainingEmiCount(Loan loan, int currentEmiNumber) {
        double balanceAmount = getBalanceAmount(loan, currentEmiNumber);
        if (balanceAmount <= 0) {
            return 0;
        }
        return (int)Math.ceil(balanceAmount/ loan.getEmi());
    }

    /**
     * Computed the amount paid till currentEMINumber
     * @param loan for which current amount paid needs to be computed
     * @param currentEmiNumber : current number of EMIs paid
     * @return the amount paid till date
     */
    @Override
    public double getAmountPaid(Loan loan, int currentEmiNumber) {
        double currentLumpSumAmountTotal = 0;
        for (LumpSumAmount lumpSumAmount : loan.getPayments()) {
            if (lumpSumAmount.getEmiNumber() > currentEmiNumber) {
                break;
            }
            currentLumpSumAmountTotal += lumpSumAmount.getAmount();
        }
        int emiAmountTotal = loan.getEmi() * currentEmiNumber;
        double totalPaid = currentLumpSumAmountTotal + emiAmountTotal;
        double totalLoanAmount = getTotalLoanAmount(loan);
        return Math.min(totalPaid, totalLoanAmount);
    }

    /**
     * Computes and returns the balance amount based on the currentEMINumber
     * @param loan for which current amount paid needs to be computed
     * @param currentEmiNumber : current number of EMIs paid
     * @return the balance amount
     */
    @Override
    public double getBalanceAmount(Loan loan, int currentEmiNumber) {
        double totalAmount = getTotalLoanAmount(loan);
        double amountPaid = getAmountPaid(loan, currentEmiNumber);
        return totalAmount - amountPaid;
    }

    private double getTotalLoanAmount(Loan loan) {
        return getTotalLoanAmount(loan.getPrinciple(), loan.getRate(), loan.getTimeInYears());
    }

    private double getTotalLoanAmount(double principle, double rate, int timeInYears) {
        return Math.ceil(principle + (principle * rate * timeInYears) / 100);
    }

}
