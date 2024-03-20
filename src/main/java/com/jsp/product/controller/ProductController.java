package com.jsp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.product.dto.ProductRequest;
import com.jsp.product.model.Product;
import com.jsp.product.service.ProductService;
import com.jsp.product.utility.ErrorStructure;
import com.jsp.product.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ProductController {



	private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}



@Operation(description = "The endpoint is used to add the Product" , responses = {
			@ApiResponse(responseCode = "200" , description = "Product saved sucessfully"),
			@ApiResponse(responseCode = "400" , description = "Invalid input", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
//	@PostMapping(value = "/products/addProduct")
@PostMapping(value = "/products")
public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody ProductRequest productRequest)
{	
	return service.addProduct(productRequest);
}



@Operation(description = "The endpoint is used to fetch the product using ID " , responses = {
		@ApiResponse(responseCode = "200" , description = "Product found"),
		@ApiResponse(responseCode = "404" , description = "Product not found by this ID" , content = {
				@Content(schema = @Schema(implementation = ErrorStructure.class))
		})
})
//	@GetMapping(value = "/products/findByProductId/{productId}")
@GetMapping(value = "/products/{productId}")
public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId)
{
	ResponseEntity<ResponseStructure<Product>> product = service.findByProductId(productId);
	return product;
}

@Operation(description = "The endpoint is used to update the product using ID " , responses = {
		@ApiResponse(responseCode = "200" , description = "Product updated sucessfully"),
		@ApiResponse(responseCode = "404" , description = "Product not found by this ID", content = {
				@Content(schema = @Schema(implementation = ErrorStructure.class))
		})
})
//	@PutMapping(value = "/products/updateByProductId/{productId}")
@PutMapping(value = "/products/{productId}")
public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId, @RequestBody Product product)
{
	ResponseEntity<ResponseStructure<Product>> updateByProductId = service.updateByProductId(productId, product);
	return updateByProductId;
}

@Operation(description = "The endpoint is used to delete the product using ID " , responses = {
		@ApiResponse(responseCode = "200" , description = "Product  deleted sucessfully"),
		@ApiResponse(responseCode = "404" , description = "Product not found by this ID" , content = {
				@Content(schema = @Schema(implementation = ErrorStructure.class))
		})
})
//	@DeleteMapping(value = "/products/deleteByProductId/{productId}")
@DeleteMapping(value = "/products/{productId}")
public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId)
{
	ResponseEntity<ResponseStructure<Product>> deleteByProductId = service.deleteByProductId(productId);
	return deleteByProductId;
}

@Operation(description = "The endpoint is used to get all the Product objects" , responses = {
		@ApiResponse(responseCode = "200" , description = "Product objects displayed sucessfully"),
		@ApiResponse(responseCode = "404" , description = "Product not found" , content = {
				@Content(schema = @Schema(implementation = ErrorStructure.class))
		})
})
//	@GetMapping(value = "/products/findAllProduct")
@GetMapping(value = "/products")
public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct()
{
	ResponseEntity<ResponseStructure<List<Product>>> allProduct = service.findAllProduct();
	return allProduct;
}


}
