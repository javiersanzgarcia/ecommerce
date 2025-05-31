package com.hexagonal.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.out.println("=============== Starting Ecommerce Application");
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
