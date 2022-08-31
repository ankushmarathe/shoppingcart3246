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
import org.springframework.web.client.RestTemplate;

import com.wallet.api.model.User;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.WalletRepository;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletRepository walletRepository;


	@GetMapping("/allWallets")// get the list of all wallets
	public List<Wallet> getWallet() {
		return walletRepository.findAll();
	}
	
	@GetMapping("/a")
	public List<Wallet> a() {
		return walletRepository.findAll();
	}
	
	
	@PostMapping("/saveWallet")// post the wallet
	public Wallet postWallet(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	@PutMapping("/editWallet/{wId}")// edit the existent wallet
	public Wallet putWallet(@PathVariable("wId") Long wId, @RequestBody Wallet wallet) {
		Wallet wallet1=walletRepository.getById(wId);
		
		if(wallet.getBalance()!=0) wallet1.setBalance(wallet.getBalance());

		return walletRepository.save(wallet1);
	}
	
	@DeleteMapping("/deleteWallet/{wId}")// delete the existent wallet
	public List<Wallet> deleteWallet(@PathVariable("wId") Long wId){
		Wallet wallet1=walletRepository.getById(wId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(wId);
		return walletRepository.findAll();
	}
	
	
	@GetMapping("/u/{uId}")
	public Wallet getWalletByUserId(@PathVariable("uId") Long uId) {
		RestTemplate restTemplate=new RestTemplate();
		
		User user=restTemplate.getForObject("http://localhost:1000/user/"+uId, User.class);
		
		if(user.getUserId()!=0) return walletRepository.getByUserId(uId);
		return new Wallet();
	}
	
	@PostMapping("/saveWallet/{uId}")// post the wallet
	public Wallet postWallet(@RequestBody Wallet wallet, @PathVariable("uId") Long uId) {
		
		RestTemplate restTemplate=new RestTemplate();
		
		User user=restTemplate.getForObject("http://localhost:1000/user/"+uId, User.class);
		
		if(user!=null) {
			wallet.setUserId(uId);
			return walletRepository.save(wallet);
		}
		
		return new Wallet();
	}
	
	@DeleteMapping("/deleteWallet/{uId}")// delete the existent wallet
	public List<Wallet> deleteWalletByUserId(@PathVariable("uId") Long uId){
		Wallet wallet1=walletRepository.getByUserId(uId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(uId);
		return walletRepository.findAll();
	}
}
