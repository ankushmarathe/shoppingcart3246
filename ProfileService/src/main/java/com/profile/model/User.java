package com.profile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Long userId;
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private String Address;
	@Column(nullable = false)
	private String role;
	
	private Long mobile;
	
	private int age;
	
	@Column(nullable = false)
	private String email;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
