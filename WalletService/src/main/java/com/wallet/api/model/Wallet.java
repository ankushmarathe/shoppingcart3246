package com.wallet.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Long userId;
	private int balance=0;
	private String productName;
	private String description;
	
	
	
	public Wallet() {
		super();
	}
	public Wallet(Long id, Long userId, int balance, String productName, String description) {
		super();
		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.productName = productName;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", userId=" + userId + ", balance=" + balance + ", productName=" + productName
				+ ", description=" + description + "]";
	}
	
	
	
	
}
