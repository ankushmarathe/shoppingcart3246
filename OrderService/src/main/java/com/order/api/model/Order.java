package com.order.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private LocalDate orderDate;
	private int customerId;
	private double ammountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, LocalDate orderDate, int customerId, double ammountPaid, String modeOfPayment,
			String orderStatus, int quantity) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.ammountPaid = ammountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmmountPaid() {
		return ammountPaid;
	}

	public void setAmmountPaid(double ammountPaid) {
		this.ammountPaid = ammountPaid;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", ammountPaid=" + ammountPaid + ", modeOfPayment=" + modeOfPayment + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + "]";
	}
	
	
}
