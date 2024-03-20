package com.jsp.product;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.product.model.Product;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
//		Product p = null;
//		Optional.of(p).map(pro->{System.out.println("Inside map");
//		return pro;}).orElseThrow(()-> new RuntimeException());
	}

}

// jpa,web,data,mysql