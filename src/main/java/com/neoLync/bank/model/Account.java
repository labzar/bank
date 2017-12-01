package com.neoLync.bank.model;

import java.util.Date;

public class Account {
	private long id;
	private long ownerId;
	private double balance;
	private Date creationDate;
	
	public Account(long id, long ownerId, double balance, Date creationDate) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.balance = balance;
		this.creationDate = creationDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long code) {
		this.id = code;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", ownerId=" + ownerId + ", balance=" + balance + ", creationDate=" + creationDate
				+ "]";
	};
	
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double withdraw (double amount) throws Exception {
		if (balance - amount < 0) {
			throw new Exception("You don't have enough balance");
		} 
		balance -= amount;
		return balance;
	}


}
