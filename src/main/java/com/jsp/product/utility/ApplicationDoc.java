package com.jsp.product.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	
	Contact contat() {
		return new Contact().name("Nikhil")
				.url("amazon.in")
				.email("nikhilmy09@gmail.com");
	}
	
	@Bean
	Info info() {
		return new Info().title("Product Management System")
				.description("RESTful API basicRUD operation")
				.version("v1").contact(contat());
	}
	
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}

}
