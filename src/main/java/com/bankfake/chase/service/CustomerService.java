package com.bankfake.chase.service;

import com.bankfake.chase.model.Customers;
import com.bankfake.chase.repo.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
    private CustomersRepository customersRepository;

    public Customers saveCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

    public List<Customers> getCustomersByLastName(String lastName) {
        return  customersRepository.findByLastName(lastName);
    }
}
