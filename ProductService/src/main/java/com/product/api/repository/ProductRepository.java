package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.product.api.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
    Product getById(Integer id);
     
	@Query("select p from Product p where p.category=?1")
	public List<Product> getProductByCategory(String category);

	List<Product> getProductByProductType(String type);

	List<Product> getProductByProductName(String name);
	

//	
//	@Query("select n from Product n where n.name=?1")
//	public List<Product> getProductByProductName(String name);

//	@Query("select p from Product p where p.id=?1")
//	Product getProductById(Integer id);
//	Product findByProductName(String name);
//	
//	Product findProductByProductType(String type);
}
