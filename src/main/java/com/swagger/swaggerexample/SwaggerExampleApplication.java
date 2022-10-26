package com.swagger.swaggerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerExampleApplication {

	public static void main(String[] args) {
		System.out.println("This is where the spring application starts");
		SpringApplication.run(SwaggerExampleApplication.class, args);
	}

}
