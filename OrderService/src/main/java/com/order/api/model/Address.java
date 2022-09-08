package com.order.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String mobileNumber;
	
	
	private int flatNumber;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int pincode;
	
	@Column(nullable = false)
	private String state;
	
	
	@JsonBackReference
	@ManyToMany(mappedBy = "address",fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	

	public Address(Long id, String fullName, String mobileNumber, int flatNumber, String city, int pincode,
			String state) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [customerId=" + id + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", flatNumber=" + flatNumber + ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}
	
	
}
