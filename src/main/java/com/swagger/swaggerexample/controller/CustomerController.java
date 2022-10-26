package com.swagger.swaggerexample.controller;

import com.swagger.swaggerexample.model.Customer;
import com.swagger.swaggerexample.model.Order;
import com.swagger.swaggerexample.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Customer customer){
        customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("A new customer was created");
    }

    @PutMapping("/addOrder/{customerId}")
    public ResponseEntity<Customer> addOrder(@RequestBody Order order, @PathVariable int customerId){
        System.out.println(order.getOrderQuantity());
        customerService.saveOrder(order, customerId);
        Customer customer = customerService.getById(customerId);
        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers =  customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.FOUND).body(customers);
    }

    @GetMapping("/orderReview/{customerId}")
    public ResponseEntity<String> getPriceDetails(@PathVariable int customerId){
        int totalPrice  = customerService.totalPrice(customerId);
        String price = "The total price for your order will be "+totalPrice;
        return ResponseEntity.status(HttpStatus.OK).body(price);
    }
}
