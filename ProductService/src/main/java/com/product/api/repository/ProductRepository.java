package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.api.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product> findById(Product pid);

	Product getProductById(Long pid);



}
