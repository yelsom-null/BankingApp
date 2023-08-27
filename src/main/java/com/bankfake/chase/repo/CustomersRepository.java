package com.bankfake.chase.repo;

import com.bankfake.chase.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    List<Customers> findByLastName(String lastName);

}
