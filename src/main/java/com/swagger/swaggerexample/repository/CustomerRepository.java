package com.swagger.swaggerexample.repository;

import com.swagger.swaggerexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
