package com.shoppingcartgateway.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class Demo {

	@GetMapping("/a")
	public String g() {
		return "A";
	}
}
