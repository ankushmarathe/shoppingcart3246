package com.cart.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.api.model.Cart;
import com.cart.api.repository.CartRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	
	// display the records from  cart
	@GetMapping("/getcart")
	@ApiOperation(value="find all product in the cart",
	response=Cart.class)
	public List<Cart> getCart() {
		
		return cartRepository.findAll();
	}
	//posting the records in the cart
	@PostMapping("/addcart")
	@ApiOperation(value="add product in the cart",
	response=Cart.class)
	public Cart postCart(@RequestBody Cart cart)
	{
		return cartRepository.save(cart);
		
	}
	//update cart
	@PutMapping("/updatecart/{cId}")
	@ApiOperation(value="update product by id",
	notes = "provide an id of the product and update it",
	response=Cart.class)
	public Cart updateCart(@ApiParam(value="ID value for updation you need to be retrive",required = true) @PathVariable("cId") Long cId, @RequestBody Cart cart) {
		Cart cart1=cartRepository.getById(cId);
		
		if(cart.getPrice()!=0 && cart.getQuantity()!=0)
		{
			cart1.setPrice(cart.getPrice());
		    cart1.setQuantity(cart.getQuantity());
		}

		return cartRepository.save(cart1);
	}
	//delete product in cart using cart id
	@DeleteMapping("/deletecart/{cId}")
	@ApiOperation(value="deletet product by id",
	notes = "provide an id of the product and delete it",
	response=Cart.class)
	public List<Cart> deleteCart(@ApiParam(value="ID value for deletion you need to be retrive",required = true) @PathVariable("cId") Long cId){
		cartRepository.deleteById(cId);
		return cartRepository.findAll();
	}
	
	
	

}
