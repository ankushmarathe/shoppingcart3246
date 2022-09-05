package com.wallet.api.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private Long userId;
	private int balance=0;
	private boolean activate=false;
	
	@JsonIgnore
	@JsonManagedReference
	@ManyToMany()
	@JoinTable(
			name ="statement_list",
			joinColumns = @JoinColumn(name="wid"),
			inverseJoinColumns = @JoinColumn(name="sid")
			)
	private List<Statement> statementList;
	
	
	
	
	public Wallet() {
		super();
	}
	
	public Wallet(Long id, Long userId, int balance, boolean activate, List<Statement> statementList) {
		super();
		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.activate = activate;
		this.statementList = statementList;
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
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public List<Statement> getStatementList() {
		return statementList;
	}

	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", userId=" + userId + ", balance=" + balance + ", activate=" + activate
				+ ", statementList=" + statementList + "]";
	}
	
	
	
}
