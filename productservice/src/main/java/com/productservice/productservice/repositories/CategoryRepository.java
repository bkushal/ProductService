package com.productservice.productservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.productservice.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
	List<Category> findByName(String name);
}
