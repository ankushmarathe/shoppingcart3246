package com.wallet.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Statement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private long userId;
	@Column(nullable = false)
	private Long orderID;
	@Column(nullable = false)
	private double paid;
	@Temporal(TemporalType.DATE)
	private Date sDate;
	
	@JsonBackReference
	@ManyToMany()
	private List<Wallet> walletList;

	public Statement(Long id, long userId, Long orderID, double paid, Date sDate, List<Wallet> walletList) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderID = orderID;
		this.paid = paid;
		this.sDate = sDate;
		this.walletList = walletList;
	}

	public Statement() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public List<Wallet> getWalletList() {
		return walletList;
	}

	public void setWalletList(List<Wallet> walletList) {
		this.walletList = walletList;
	}
	
	
	
	
}
