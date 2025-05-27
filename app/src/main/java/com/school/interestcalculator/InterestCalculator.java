package com.school.interestcalculator;
import java.util.ArrayList;
import java.util.List;

public class InterestCalculator {
    private static final int MONTHS_IN_YEAR = 12;
    public List<Double> balanceWithAdditionalDeposits (double initialBalance, double monthlyDeposit, double interest, int numYears) {
        validateInputs(initialBalance, monthlyDeposit, interest, numYears);

        List<Double> yearlyBalanceWithDeposits = new ArrayList<>();
        yearlyBalanceWithDeposits.add(initialBalance); //Adds the initial balance as the starting point

        double monthlyRate = interest / 1200.0; //Monthly interest rate
        double currentBalance = initialBalance;

        for (int year = 1; year <= numYears; ++year) {

            double futureBalance = calculateFutureValue(
                    currentBalance,
                    monthlyDeposit,
                    monthlyRate,
                    MONTHS_IN_YEAR
            );

            currentBalance = futureBalance;
            yearlyBalanceWithDeposits.add(currentBalance);
        }
        return yearlyBalanceWithDeposits;
    }

    public List<Double> balanceWithoutAdditionalDeposits (double initialBalance, double interest, int numYears) {
        validateInputs(initialBalance, 0, interest, numYears);

        List<Double> yearlyBalance = new ArrayList<>();
        yearlyBalance.add(initialBalance); //Adds the initial balance as the starting point

        double monthlyRate = interest / 1200.0; //Monthly interest rate
        double currentBalance = initialBalance;

        for (int year = 1; year <= numYears; ++year) {
            currentBalance *= Math.pow(1 + monthlyRate, MONTHS_IN_YEAR); //applies 12 months of growth at once
            yearlyBalance.add(currentBalance);
        }
        return yearlyBalance;
    }

    private double calculateFutureValue (double presentValue, double monthlyDeposit, double monthlyRate, int timeFrame) { //function used for calculating future value for monthly deposits interest.
        return presentValue * Math.pow(1 + monthlyRate, timeFrame)
                + monthlyDeposit * (Math.pow(1 + monthlyRate, timeFrame) - 1) / monthlyRate;
    }

    private void validateInputs (double initialBalance, double monthlyDeposit, double interest, int years) { //function used to ensure inputs cannot be negative.
        if (initialBalance < 0 || monthlyDeposit < 0 || years < 0) {
            throw new IllegalArgumentException("Inputs cannot be a negative value");
        }
        if (interest < 0) {
            throw new IllegalArgumentException("Interest rate cannot be a negative value");
        }
    }
}
