package com.bankfake.chase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    private Long id;

    private int accountNumber;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String address;
    private String memberSince;
    private int accountBalance;
    private double numberOfAccounts;

    @OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
    private List<BankAccount> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
    private List<Card> card = new ArrayList<>();

    public Customers() {
    }

    public Customers(int accountNumber, String firstName, String lastName, String cardNumber, String address, String memberSince, double accountBalance, int numberOfAccounts) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.address = address;
        this.memberSince = memberSince;
        this.accountBalance = (int) accountBalance;
        this.numberOfAccounts = numberOfAccounts;
        this.accounts = new ArrayList<>();
        this.card = new ArrayList<>();
    }


    public void createBankAccount(double firstDeposit){
        BankAccount newAccount = new BankAccount("Checking",firstDeposit);
        this.accounts.add(newAccount);
        printDetails();
    }
    private void printDetails() {
        System.out.println("Account Holder: " + firstName + " " +  lastName);
    }

    public BankAccount getBankAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){return account;}
        } return null;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(BankAccount newAccount){
        this.accounts.add(newAccount);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getNumberOfAccounts() {
        return (int) numberOfAccounts;
    }


    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }
    public void printAccount() {
        for (BankAccount account : this.accounts) {
            System.out.println(account);
        }
    }



    @Override
    public String toString() {
        return "Customers{" +
                "accountNumber=" + accountNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", address='" + address + '\'' +
                ", memberSince='" + memberSince + '\'' +
                ", accountBalance=" + accountBalance +
                ", numberOfAccounts=" + numberOfAccounts +
                '}';
    }
}

