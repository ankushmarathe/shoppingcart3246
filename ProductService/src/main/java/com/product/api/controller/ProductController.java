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

import io.swagger.annotations.ApiOperation;


@RestController
public class ProductController {
	@Autowired
	private ProductRepository  productRepository;
	
	//Add Products 
	
	@PostMapping("/product")
	@ApiOperation(value="Add products in DB",
	response=Product.class)
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
}	
	//Get All Products
	@ApiOperation(value="Fetch all products",
			response=Product.class)
	@GetMapping("/product")
	public List<Product> getProduct(){
		List<Product> list = productRepository.findAll();
		return list;
	}
	

	
	// Update Product
	
	 @PutMapping("/product/update/{pid}")
	 @ApiOperation(value="update product by id",
		notes = "provide an id of the product and update it",
		response=Product.class)
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
			


			if (proNew.getPrice()!= 0l)
				proDB.setPrice(proNew.getPrice());
			
			if (proNew.getDescription()!=null)
				proDB.setDescription(proNew.getDescription());
			
			if (proNew.getSpecification()!=null)
				proDB.setSpecification(proNew.getSpecification());
		 
			return productRepository.save(proDB);
	
}
	 //Delete Product 
	 
	 @DeleteMapping("/product/delete/{pid}")
	 @ApiOperation(value="Delete product by id",
		notes = "provide an id of the product and delete it",
		response=Product.class)
	 public void deleteProduct(@PathVariable("pid") Long pid) {
		  productRepository.deleteById(pid); 
	 }
		//Get Product BY ID

//     @GetMapping("/product/{pid}")
//     @ApiOperation(value="Fetch product by id",
// 	notes = "provide an id of the product and fetch it",
// 	response=Product.class)
//	public Product getProductById(@PathVariable("pid")Long pid) {
//		return productRepository.findProductById(pid);
//	}
	 
//	 @GetMapping("/product/{id}")
//		@ApiOperation(value="get product by id",
//		notes = "provide an id of the product and fetch it",
//		response=Product.class)
//		public Product getByUserId(@PathVariable("id") long id) {
//			
//			Product user= productRepository.getById(id);
//		
//			return user;
//		}
	 
	 
	 //Get Product By Id
	 
	 @GetMapping ("/product/{id}")
	 public Product getProductbyId(@PathVariable ("id") Integer id) {
		 return productRepository.getById(id);
	 }
     //Get Product By Name
     
    @GetMapping("/product/name/{name}")
     public List<Product> getProductByProductName(@PathVariable("name") String name) {
    	 return productRepository.getProductByProductName(name);
     }
     
     // Get Product By Category
     @GetMapping("/product/category/{category}")
     public List<Product> getProductByCategory(@PathVariable("category") String category) {
    	 return productRepository.getProductByCategory(category);
    	 
     }
     //Get Product By Type
     @GetMapping("/product/type/{type}")
     public List<Product> getProductByType(@PathVariable("type") String type) {
    	 return productRepository.getProductByProductType(type);
    	 
     }

	
}