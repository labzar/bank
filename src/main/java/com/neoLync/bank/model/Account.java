package com.neoLync.bank.model;

import java.util.Date;

public class Account {
	private int code;
	private Client owner;
	private double balance;
	private Date creationDate;
	
	public Account(int code, Client owner, double balance, Date creationDate) {
		super();
		this.code = code;
		this.owner = owner;
		this.balance = balance;
		this.creationDate = creationDate;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
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
		return "Account [code=" + code + ", owner=" + owner + ", balance=" + balance + ", creationDate=" + creationDate
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
