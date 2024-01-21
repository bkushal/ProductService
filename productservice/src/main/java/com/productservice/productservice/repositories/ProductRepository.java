package com.productservice.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
