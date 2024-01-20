package com.productservice.productservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{
		return this.productService.getProductById(id);
	}
	
	@GetMapping
	public List<GenericProductDto> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@DeleteMapping("/{id}")
	public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
		return this.productService.deleteProductById(id);
	}
	
	@PostMapping
	public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
		return this.productService.createProduct(genericProductDto);
	}
	
	public void updateProductById() {
		
	}
	
	/*@ExceptionHandler(ProductNotFoundException.class)
	private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException exception) {
		//ResponseEntity<ExceptionDto> response = new ResponseEntity<ExceptionDto>();
		ExceptionDto exceptionDto = new ExceptionDto();
		exceptionDto.setMessage(exception.getMessage());
		exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.NOT_FOUND);
	}*/
}
