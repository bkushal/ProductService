package com.productservice.productservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
	
	private RestTemplateBuilder restTemplateBuilder;
	private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
	private String genericProductUrl = "https://fakestoreapi.com/products";
	
	FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Override
	public GenericProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.getForEntity(this.specificProductUrl, FakeStoreProductDto.class, id);
		
		return this.convertToGenericProductDto(responseEntity.getBody());
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto[]> responseEntity = 
				restTemplate.getForEntity(this.genericProductUrl, FakeStoreProductDto[].class);
		
		List<GenericProductDto> result = new ArrayList<>();
		List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
		for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
				result.add(this.convertToGenericProductDto(fakeStoreProductDto));
		
		return result;
	}

	@Override
	public GenericProductDto deleteProductById(Long id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();

		RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
		ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
		ResponseEntity<FakeStoreProductDto> responseEntity = (restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id));
		return this.convertToGenericProductDto(responseEntity.getBody());
		
	}

	@Override
	public GenericProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);
		
		return this.convertToGenericProductDto(responseEntity.getBody());
		
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
