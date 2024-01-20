package com.productservice.productservice.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

public interface ProductService {
	GenericProductDto getProductById(Long id) throws ProductNotFoundException;
	List<GenericProductDto> getAllProducts();
	GenericProductDto deleteProductById(Long id);
	GenericProductDto createProduct(GenericProductDto genericProductDto);
	void updateProductById();
	
}
