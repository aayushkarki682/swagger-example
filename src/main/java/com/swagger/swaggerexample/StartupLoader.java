package com.swagger.swaggerexample;

import com.swagger.swaggerexample.model.Product;
import com.swagger.swaggerexample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StartupLoader implements CommandLineRunner {
    private final ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        Product p1 = Product.builder().name("cup").price(12).quantity(30).build();
        Product p2 = Product.builder().name("plate").price(19).quantity(25).build();
        productRepository.save(p1);
        productRepository.save(p2);

    }
}
