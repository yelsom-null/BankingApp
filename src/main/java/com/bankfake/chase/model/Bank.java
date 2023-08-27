package com.bankfake.chase.model;



import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String nameOfBank;
    private String addressOfBank;
    private String HOURS_OF_OPERATION;
    private int numberOfEmployees;
    private String cityOfBank;
    private List<Customers> customers;
    private List<Employees> employees;
    public Bank(){}

    public Bank(String nameOfBank){

        this.nameOfBank = nameOfBank;
        this.customers = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public String getAddressOfBank() {
        return addressOfBank;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public String getHOURS_OF_OPERATION() {
        return HOURS_OF_OPERATION;
    }

    private int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getCityOfBank() {
        return cityOfBank;
    }

    public void setAddressOfBank(String addressOfBank) {
        this.addressOfBank = addressOfBank;
    }

    public void setHOURS_OF_OPERATION(String HOURS_OF_OPERATION) {
        this.HOURS_OF_OPERATION = HOURS_OF_OPERATION;
    }

    private void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setCityOfBank(String cityOfBank) {
        this.cityOfBank = cityOfBank;
    }

    public void addCustomer(Customers customer){
        this.customers.add(customer);
    }

    public void addEmployee(Employees employee){
        this.employees.add(employee);
    }
    public void printAllCustomers() {
        for(Customers customer : this.customers) {
            System.out.println(customer);
        }
    }
    public void printAllEmployees() {
        for(Employees employee : this.employees) {
            System.out.println(employee);
        }
    }

}
