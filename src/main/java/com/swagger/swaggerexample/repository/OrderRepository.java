package com.swagger.swaggerexample.repository;

import com.swagger.swaggerexample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
