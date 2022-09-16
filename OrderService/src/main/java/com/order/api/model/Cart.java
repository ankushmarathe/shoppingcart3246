package com.order.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private Long userId;

	private String productName;
	
	private Double price;
	
	private int quantity;
	
	@ManyToMany
	@JoinTable(
		name = "cart_items",
		joinColumns = @JoinColumn(name="cartId"),
		inverseJoinColumns=@JoinColumn(name="itemId")
		)
	private List<Items> items;



	public Cart(Long id, Long userId, String productName, Double price, int quantity, List<Items> items) {
		super();
		this.id = id;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.items = items;
	}
	
	public Cart() {
		super();
			// TODO Auto-generated constructor stub
	}
	public Cart(long id,long userId, String productName, double price, int quantity) {
	
		this.id = id;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, productName, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(id, other.id) && Objects.equals(price, other.price)
				&& Objects.equals(productName, other.productName) && quantity == other.quantity;
	}

	
	

}