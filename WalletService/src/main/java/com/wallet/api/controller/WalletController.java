package com.wallet.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

	@GetMapping("/wallet")
	public String getString() {
		return "WalletService";
	}
}
