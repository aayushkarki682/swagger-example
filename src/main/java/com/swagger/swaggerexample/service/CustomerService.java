package com.swagger.swaggerexample.service;

import com.swagger.swaggerexample.model.Order;
import com.swagger.swaggerexample.model.Product;
import com.swagger.swaggerexample.repository.CustomerRepository;
import com.swagger.swaggerexample.repository.OrderRepository;
import com.swagger.swaggerexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import com.swagger.swaggerexample.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void saveOrder(Order order, int customerId){
        Customer customer = customerRepository.getById(customerId);
        order.setCustomer(customer);
        orderRepository.save(order);
        customer.getOrders().add(order);
        customerRepository.save(customer);


    }

    public Customer getById(int id){
        return customerRepository.getById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public int totalPrice(int customerId){
        Customer customer = customerRepository.getById(customerId);
        Set<Order> orders = customer.getOrders();
        int totalPrice = 0;
        for(Order order : orders){
            String productName = order.getProductName();
            Product product = productRepository.findByName(productName);
            totalPrice += product.getPrice() * order.getOrderQuantity();
        }
        return totalPrice;
    }


}
