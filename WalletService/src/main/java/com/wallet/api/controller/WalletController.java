package com.wallet.api.controller;

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

import com.wallet.api.model.Wallet;
import com.wallet.api.repository.WalletRepository;

@RestController
public class WalletController {

	@Autowired
	WalletRepository walletRepository;


	@GetMapping("/walletS")// get the list of all wallets
	public List<Wallet> getWallet() {
		return walletRepository.findAll();
	}
	
	@GetMapping("/a")
	public List<Wallet> a() {
		return walletRepository.findAll();
	}
	
	
	@PostMapping("/wallet")// post the wallet
	public Wallet postWallet(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	@PutMapping("/wallet/{wId}")// edit the existent wallet
	public Wallet putWallet(@PathVariable("wId") Long wId, @RequestBody Wallet wallet) {
		Wallet wallet1=walletRepository.getById(wId);
		
		if(wallet.getBalance()!=0) wallet1.setBalance(wallet.getBalance());

		return walletRepository.save(wallet1);
	}
	
	@DeleteMapping("/wallet/{wId}")// delete the existent wallet
	public List<Wallet> deleteWallet(@PathVariable("wId") Long wId){
		Wallet wallet1=walletRepository.getById(wId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(wId);
		return walletRepository.findAll();
	}
}
