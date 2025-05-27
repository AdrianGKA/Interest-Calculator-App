package com.school.interestcalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class InterestCalculatorViewModel extends ViewModel {
    private final InterestCalculator calculator = new InterestCalculator();
    private final MutableLiveData<List<Double>> balanceWithDeposits = new MutableLiveData<>();
    private final MutableLiveData<List<Double>> balanceWithoutDeposits = new MutableLiveData<>();

    public void calculateBalances (double balance, double deposit, double interest, int years) {
        balanceWithDeposits.setValue(calculator.balanceWithAdditionalDeposits(balance, deposit, interest, years));
        balanceWithoutDeposits.setValue(calculator.balanceWithoutAdditionalDeposits(balance, interest, years));
    }

    //Exposes LiveData for views to observe
    public LiveData<List<Double>> getBalanceWithDeposits() {
        return balanceWithDeposits;
    }
    public LiveData<List<Double>> getBalanceWithoutDeposits() {
        return balanceWithoutDeposits;
    }



}
