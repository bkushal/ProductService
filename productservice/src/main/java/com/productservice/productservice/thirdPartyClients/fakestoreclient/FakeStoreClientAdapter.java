package com.productservice.productservice.thirdPartyClients.fakestoreclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

@Component
public class FakeStoreClientAdapter {
	
	private String fakeStoreUrl;
	
	private String pathForProducts;

	private RestTemplateBuilder restTemplateBuilder;
	private String specificProductUrl;
	private String genericProductUrl;
	
	FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,
			@Value("${fakestore.api.url}") String fakeStoreUrl,
			@Value("${fakestore.api.paths.products}") String pathForProducts){
		
		this.restTemplateBuilder = restTemplateBuilder;
		this.specificProductUrl = specificProductUrl = fakeStoreUrl+pathForProducts+ "/{id}";;
		this.genericProductUrl = fakeStoreUrl+pathForProducts;
	}

	public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.getForEntity(this.specificProductUrl, FakeStoreProductDto.class, id);
		FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
		if(fakeStoreProductDto == null) {
			throw new ProductNotFoundException("Product with the id: "+id+" does not exist");
		}
		return fakeStoreProductDto;
		//return this.convertToGenericProductDto(fakeStoreProductDto);
	}

	public List<FakeStoreProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto[]> responseEntity = 
				restTemplate.getForEntity(this.genericProductUrl, FakeStoreProductDto[].class);
		
		List<GenericProductDto> result = new ArrayList<>();
		return List.of(responseEntity.getBody());
	}

	public FakeStoreProductDto deleteProductById(Long id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();

		RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
		ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
		ResponseEntity<FakeStoreProductDto> responseEntity = (restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id));
		return responseEntity.getBody();
		
	}

	public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);
		
		return responseEntity.getBody();
		
	}

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
