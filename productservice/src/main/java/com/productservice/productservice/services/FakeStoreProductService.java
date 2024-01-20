package com.productservice.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
	
	private RestTemplateBuilder restTemplateBuilder;
	private String getProductUrl = "https://fakestoreapi.com/products/1";
	
	FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Override
	public GenericProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.getForEntity(this.getProductUrl, FakeStoreProductDto.class);
		
		
		
		return this.convertToGenericProductDto(responseEntity.getBody());
	}

	@Override
	public void getAllProducts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductById() {
		// TODO Auto-generated method stub
		
	}
	
	private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
		GenericProductDto genericProductDto = new GenericProductDto();
		genericProductDto.setId(fakeStoreProductDto.getId());
		genericProductDto.setCategory(fakeStoreProductDto.getCategory());
		genericProductDto.setDescription(fakeStoreProductDto.getDescription());
		genericProductDto.setImage(fakeStoreProductDto.getImage());
		genericProductDto.setPrice(fakeStoreProductDto.getPrice());
		genericProductDto.setTitle(fakeStoreProductDto.getTitle());
		
		return genericProductDto;
	}

}
