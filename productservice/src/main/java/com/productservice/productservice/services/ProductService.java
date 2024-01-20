package com.productservice.productservice.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;

public interface ProductService {
	GenericProductDto getProductById(Long id);
	List<GenericProductDto> getAllProducts();
	GenericProductDto deleteProductById(Long id);
	GenericProductDto createProduct(GenericProductDto genericProductDto);
	void updateProductById();
	
}
