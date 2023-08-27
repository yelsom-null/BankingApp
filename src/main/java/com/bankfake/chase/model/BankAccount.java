package com.bankfake.chase.model;


import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Random;

/*
BankAccount: Attributes would be accountNumber, routingNumber, balance, etc. Methods would include deposit(), withdraw(), checkBalance(), etc.
 */
@Entity
public class BankAccount {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String accountNumber;
    static private long ROUTING_NUMBER;
    private String accountName;
@Embedded
    private Balance balance;
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    public BankAccount() {
    }

    public BankAccount(String accountName, double initialBalance) {
        this.accountNumber = generateRandomAccountNumber();
        this.ROUTING_NUMBER = 32351098;
        this.accountName = accountName;
        this.balance = new Balance(initialBalance);
        this.card = new Card();
        printDetails();
    }

    private void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Routing Number: " + ROUTING_NUMBER);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance); // This assumes that the Balance class has a proper toString() method
        System.out.println("Card Details: " + card); // This assumes that the Card class has a proper toString() method
    }
    public String getAccountNumber() {
        return accountNumber;
    }



    public long getRoutingNumber() {
        return ROUTING_NUMBER;
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1_000_000_000));
    }

    public Balance getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
