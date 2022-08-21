package com.cart.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	@GetMapping("/cart")
	public String getString() {
		return "CartService";
	}

}
