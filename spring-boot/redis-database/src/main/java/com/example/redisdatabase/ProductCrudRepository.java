package com.example.redisdatabase;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ProductCrudRepository extends CrudRepository<Product, String> {
	
	List<Product> findAll();
	List<Product> findByNameContains(String searchName);
}
