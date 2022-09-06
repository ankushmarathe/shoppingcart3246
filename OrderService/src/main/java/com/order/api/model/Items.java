package com.order.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int quantity;

	@OneToOne
	private Cart cart;
	
	@OneToOne
	private Product product;
	

	public Items(Long itemId, String productName, double price, int quantity) {
		super();
		this.itemId = itemId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
}
