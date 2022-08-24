package com.cart.api.model;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
private String productName;
private Double price;
private int quantity;


public Cart(long id, String productName, double price, int quantity) {
	
	this.id = id;
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
public int getTotalItems() {
	 ArrayList<String> items = new ArrayList<>();
	return items.size();
}






}
