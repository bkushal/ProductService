package com.productservice.productservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClientAdapter;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
	
	private FakeStoreClientAdapter fakeStoreAdapter;
	
	FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter){
		this.fakeStoreAdapter = fakeStoreAdapter;
	}

	@Override
	public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return this.convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		List<FakeStoreProductDto> fakeStoreProductDtos = this.fakeStoreAdapter.getAllProducts();
		List<GenericProductDto> result = new ArrayList<>();
		for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
			result.add(this.convertToGenericProductDto(fakeStoreProductDto));
		
		return result;
	}

	@Override
	public GenericProductDto deleteProductById(Long id) {
		// TODO Auto-generated method stub
		return this.convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
		
	}

	@Override
	public GenericProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub
		return this.convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
		
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
