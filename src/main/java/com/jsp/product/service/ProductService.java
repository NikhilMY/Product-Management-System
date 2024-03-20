package com.jsp.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.product.dto.ProductRequest;
import com.jsp.product.model.Product;
import com.jsp.product.utility.ResponseStructure;

public interface ProductService {
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest productRequest);
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId,Product updatedProduct);
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();

}
