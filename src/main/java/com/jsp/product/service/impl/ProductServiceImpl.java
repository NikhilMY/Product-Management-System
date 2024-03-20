package com.jsp.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.product.dto.ProductRequest;
import com.jsp.product.exception.ProductNotFoundByIdException;
import com.jsp.product.model.Product;
import com.jsp.product.model.User;
import com.jsp.product.repository.ProductRepository;

import com.jsp.product.service.ProductService;
import com.jsp.product.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

	
	private ProductRepository repository;
//	in xml dependency injection there are two types 1)Constructor injection 2)Setter injection
//  but in annotation dependency injection there are three types 1)Constructor injection 2)Setter injection 3)Feild type injection(Autowired)
//	but we use Constructor injection bcz it is tightly coupled and it is more strict type
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	
//	OR
	
//	private ProductRepository repository;
//	private ResponseStructure<Product> rs;
//	private ResponseStructure<List<Product>> listrs;	
//	public ProductServiceImpl(ProductRepository repository,ResponseStructure<Product> rs, ResponseStructure<List<Product>> listrs) {
//		this.repository = repository;
//		this.rs=rs;
//		this.listrs=listrs;
//	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(ProductRequest productRequest) {
//		Product product2 = repository.save(product);
//		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
//		responseStructure.setStatuscode(HttpStatus.CREATED.value());
//		responseStructure.setMessage("Product added sucessfully!!!");
//		responseStructure.setData(product2);
//		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		
//		map dto to entity
		Product product = repository.save(mapToProduct(productRequest, new Product()));
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value()).
				setMessage("Product saved sucessfully").
				setData(product));
	}

	private Product mapToProduct(ProductRequest productRequest, Product product) {
	product.setpName(productRequest.getpName());
	product.setpCost(productRequest.getpCost());
	return product;
	
}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
		
//		Optional<Product> optional = repository.findById(productId);
//		if(optional.isPresent())
//		{
//			Product product = optional.get();
//			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("The data of Product displayed sucessfully!!!");
//			responseStructure.setData(product);
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
//		}
//		else {
//			  throw new  ProductNotFoundByIdException("Actor Not Found!!!!!");
//		}
		
//		return repository.findById(productId).map(p->{ResponseStructure<Product> rs = new ResponseStructure<Product>();
//			return  ResponseEntity.ok(rs);
//		}).orElseThrow(()-> new ProductNotFoundByIdException("Product not foun !!!!!"));
		
		return repository.findById(productId).map(p->{ResponseStructure<Product> rs = new ResponseStructure<Product>();
		return  ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product found!!!")
				.setData(p));})
				.orElseThrow(()-> new ProductNotFoundByIdException("Product not foun !!!!!"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
//		Optional<Product> optional = repository.findById(productId);
//		if(optional.isPresent())
//		{
//			Product existingProduct = optional.get();
//			updatedActor.setpId(existingProduct.getpId());
//			 ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
//				responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
//				responseStructure.setMessage("The data of Product updated sucessfully!!!");
//				responseStructure.setData(repository.save(updatedActor));
//				return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.ACCEPTED);
//		}
//		else {
//			return null;
//		}
return repository.findById(productId).map(exp->{
	updatedProduct.setpId(exp.getpId());
	exp =repository.save(updatedProduct);
	ResponseStructure<Product> rs = new ResponseStructure<>();
	return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
			.setMessage("updated sucessfully")
			.setData(exp));	
		}).orElseThrow(()->new ProductNotFoundByIdException("Product not foun !!!!!"));
				
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
//		Optional<Product> optional = repository.findById(productId);
//		if(optional.isPresent())
//		{
//			Product product = optional.get();
//			repository.delete(product);
//			
//			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Product Data Deleted sucessfully!!!");
//			responseStructure.setData(product);
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
//		}
//		else {
//			return null;
//		}
		
		return repository.findById(productId).map(exp->{
			repository.delete(exp);
			ResponseStructure<Product> rs = new ResponseStructure<>();
			return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
					.setMessage("updated sucessfully")
					.setData(exp));	
				}).orElseThrow(()->new ProductNotFoundByIdException("Product not foun !!!!!"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
//		List<Product> actor = repository.findAll();
//		if(actor.isEmpty()) {
//			return null;
//		}
//		else {
//			ResponseStructure<List<Product>> responseStructure = new ResponseStructure<List<Product>>();
//			responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
//			responseStructure.setMessage("All The Data Of Product Displayed sucessfully!!!");
//			responseStructure.setData(actor);
//			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.ACCEPTED) ;
//	}
ResponseStructure<List<Product>> listrs = new ResponseStructure<>();

// in tis when no objects r thr it returns empty array
//		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
//				.setMessage("Product found sucessully")
//				.setData(repository.findAll()));

//but in tis when no objects r thr it returns exception
List<Product> products = repository.findAll();
if(!products.isEmpty()) {
return ResponseEntity.ok(listrs.setStatuscode(HttpStatus.OK.value())
		.setMessage("Product found sucessully")
		.setData(products));
}else  throw new ProductNotFoundByIdException("Product not found!!!!");
		
	}

}
