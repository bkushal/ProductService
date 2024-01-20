package com.productservice.productservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.FakeStoreProductService;
import com.productservice.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id){
		return this.productService.getProductById(id);
	}
	
	public void getAllProducts() {
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById() {
		
	}
	
	public void createProduct() {
		
	}
	
	public void updateProductById() {
		
	}
}
