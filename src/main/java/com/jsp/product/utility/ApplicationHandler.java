package com.jsp.product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructures<String>> productNotFoundById(ProductNotFoundByIdException ex)
	{
		ErrorStructures<String> errorStructure = new ErrorStructures<>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product object with the given id dosen't exist");
		
		return new ResponseEntity<ErrorStructures<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}

}






