package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.api.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
