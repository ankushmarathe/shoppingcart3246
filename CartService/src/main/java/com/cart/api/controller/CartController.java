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
import org.springframework.web.bind.annotation.RestController;

import com.cart.api.model.Cart;
import com.cart.api.repository.CartRepository;



@RestController
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	
	// display the records from  cart
	@GetMapping("/cart")
	public List<Cart> getCart() {
		
		return cartRepository.findAll();
	}
	//posting the records in the cart
	@PostMapping("/cart")
	public Cart postCart(@RequestBody Cart cart)
	{
		return cartRepository.save(cart);
		
	}
	//update cart
	@PutMapping("/cart/{cId}")
	public Cart updateCart(@PathVariable("cId") Long cId, @RequestBody Cart cart) {
		Cart cart1=cartRepository.getById(cId);
		
		if(cart.getPrice()!=0 && cart.getQuantity()!=0)
		{
			cart1.setPrice(cart.getPrice());
		    cart1.setQuantity(cart.getQuantity());
		}

		return cartRepository.save(cart1);
	}
	//delete product in cart using cart id
	@DeleteMapping("/cart/{cId}")
	public List<Cart> deleteCart(@PathVariable("cId") Long cId){
		cartRepository.deleteById(cId);
		return cartRepository.findAll();
	}
	
	
	

}
