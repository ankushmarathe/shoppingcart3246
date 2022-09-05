package com.wallet.api.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.razorpay.*;
import com.wallet.api.model.User;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.WalletRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	@ApiOperation(value="fetch all the wallets",
			response=Wallet.class)
	@GetMapping("/allWallets")// get the list of all wallets
	public List<Wallet> getWallet() {
		return walletRepository.findAll();
	}
	
	@GetMapping("/a")
	public List<Wallet> a() {
		return walletRepository.findAll();
	}
	
	@ApiOperation(value="Post the wallet",
			
			response=Wallet.class)
	@PostMapping("/saveWallet")// post the wallet
	public Wallet postWallet(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	@ApiOperation(value="update wallet by wallet id",
			notes = "provide an id of the wallet and update it",
			response=Wallet.class)
	@PutMapping("/editWallet/{wId}")// edit the existent wallet
	public Wallet putWallet(@PathVariable("wId") Long wId, @RequestBody Wallet wallet) {
		Wallet wallet1=walletRepository.getById(wId);
		
		if(wallet.getBalance()!=0) wallet1.setBalance(wallet.getBalance());

		return walletRepository.save(wallet1);
	}
	
	@ApiOperation(value="Delete wallet by wallet id",
			notes = "provide an id of the wallet and delete it",
			response=Wallet.class)
	@DeleteMapping("/deleteWallet/{wId}")// delete the existent wallet
	public List<Wallet> deleteWallet(@PathVariable("wId") Long wId){
		Wallet wallet1=walletRepository.getById(wId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(wId);
		return walletRepository.findAll();
	}
	
	@ApiOperation(value="Fetch wallet by userId",
			notes = "provide an id of the User and Fetch the wallet",
			response=Wallet.class)
	@GetMapping("/userid/{uId}")
	public Wallet getWalletByUserId(@PathVariable("uId") Long uId) {
		RestTemplate restTemplate=new RestTemplate();
		
		User user=restTemplate.getForObject("http://localhost:1000/user/"+uId, User.class);
		System.out.println(user.getUsername());
		if(user.getUserId()!=0) return walletRepository.getByUserId(uId);
		return new Wallet();
	}
	
	@ApiOperation(value="Post wallet by userId",
			notes = "provide an id of the User and Post the wallet",
			response=Wallet.class)
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
	
	@ApiOperation(value="Delete wallet by userId",
			notes = "provide an id of the User and Delete the wallet",
			response=Wallet.class)
	@DeleteMapping("/deleteWallet/{uId}")// delete the existent wallet
	public List<Wallet> deleteWalletByUserId(@PathVariable("uId") Long uId){
		Wallet wallet1=walletRepository.getByUserId(uId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(uId);
		return walletRepository.findAll();
	}
	
	//****************************************************************************************
	
	@ApiOperation(value="Fetch wallet balance by Price",
			notes = "provide an price and Fetch the wallet balance",
			response=Wallet.class)
	@GetMapping("/getWalletMoney/{price}")
	public long getWalletMoney(@PathVariable("price") Long price, Principal principal) {
		ResponseEntity<User> temp=restTemplate
				.getForEntity("http://localhost:1200/u/user/"+principal.getName(), User.class);
		User userDB=temp.getBody();
		
		if(userDB==null) {
			return 0;
		}
		
		Wallet wallet=walletRepository.getByUserId((long)userDB.getUserId());
		if(!wallet.isActivate()) return 0;
		
		long temp1=price/10;
		
		if(price<500) return price-temp1;
		if(price<1500) return price-(temp1+(temp1/2));
		if(price<4000) return price-(2*temp1);
		return price-(3*temp1);
	}
	
	
	
	//payment gateway api
	@ApiOperation(value="Api for Payment",
			response=Wallet.class)
	@PostMapping("/pay")
	@ResponseBody
	public String paymoneyyy(@RequestBody Map<String, Object> data) throws Exception {
		System.out.println ("--------------------------------------------------------------------");

		int amt=Integer.parseInt(data.get("amount").toString ());

		
		RazorpayClient razorpayClient = new RazorpayClient("-enter ur details-", "-enter ur details-"); 
		JSONObject options = new JSONObject(); 
		options.put("amount", amt*100); 
		options.put("currency", "INR"); 
		options.put("receipt", "txn_123456"); 
		Order order = razorpayClient.orders.create(options);
		System.out.println (order) ;
		
		return order.toString();
	}
}
