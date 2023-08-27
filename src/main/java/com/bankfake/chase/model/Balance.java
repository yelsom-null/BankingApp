package com.bankfake.chase.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Balance {
    private double initialAmount;
    private double currentBalance;
    private double deposit;
    private double withdraw;

    public Balance(double initialAmount) {
        this.currentBalance = initialAmount;
    }


    public void setDeposit(double deposit){
        this.currentBalance += deposit;
    }

    public double checkBalance(){
        return currentBalance;
    }

    public void setWithdraw(double withdraw) {
        if (currentBalance > withdraw) {
            this.currentBalance -= withdraw;
        } else {
            System.out.print("Insufficient Funds to perform withdraw!");
        }
    }

    @Override
    public String toString() {
        return " " + currentBalance;
    }
}
