package com.productservice.productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductControllerAdvices {
	
	@ExceptionHandler(ProductNotFoundException.class)
	private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
		ExceptionDto exceptionDto = new ExceptionDto();
		exceptionDto.setMessage(productNotFoundException.getMessage());
		exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
}
