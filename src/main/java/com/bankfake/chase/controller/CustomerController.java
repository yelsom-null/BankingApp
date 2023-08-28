package com.bankfake.chase.controller;

import com.bankfake.chase.model.Customers;
import com.bankfake.chase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

    public class CustomerController {
        @Autowired
        public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    private CustomerService customerService;

    @PostMapping("add")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        Customers savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customers>> getCustomerByLastName(@RequestParam String lastName){
        List<Customers> customers = customerService.getCustomersByLastName(lastName);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }



}
