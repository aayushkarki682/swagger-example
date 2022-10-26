package com.swagger.swaggerexample.service;


import com.swagger.swaggerexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import com.swagger.swaggerexample.model.Product;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
