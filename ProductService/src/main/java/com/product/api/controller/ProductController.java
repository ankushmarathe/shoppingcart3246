package com.product.api.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.model.Product;
import com.product.api.repository.ProductRepository;


@RestController
public class ProductController {
	@Autowired
	private ProductRepository  productRepository;
	
	//Add Products 
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
}	
	//Get All Products
	
	@GetMapping("/product")
	public List<Product> getProduct(){
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	//Get Product BY ID

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") long id) {
		Product product= productRepository.getById(id);
	    return product;
			}
	
	// Update Product
	
	 @PutMapping("/product/update/{pid}")
		public Product updateProduct(@PathVariable("pid")Long pid, @RequestBody Product
				proNew, Principal principal) {
			String username= principal.getName();
			
			Product proDB=  productRepository.getById(pid);
			
			if (proNew.getProductType()!=null)
				proDB.setProductType(proNew.getProductType());
			
			if (proNew.getProductName()!=null)
				proDB.setProductName(proNew.getProductName());
			
			if (proNew.getCategory()!=null)
				proDB.setCategory(proNew.getCategory());
			
//			if (proNew.getImage()!=null)
//				proDB.setImage(proNew.getImage());

//			if (proNew.getPrice()!=null)
//				proDB.setPrice(proNew.getPrice());
			
			if (proNew.getDescription()!=null)
				proDB.setDescription(proNew.getDescription());
			
			if (proNew.getSpecification()!=null)
				proDB.setSpecification(proNew.getSpecification());
		 
			return productRepository.save(proDB);
	
}
	 //Delete Product 
	 
	 @DeleteMapping("/product/delete/{pid}")
	 public void deleteProduct(@PathVariable("pid") Long pid) {
		  productRepository.deleteById(pid); 
	 }
}