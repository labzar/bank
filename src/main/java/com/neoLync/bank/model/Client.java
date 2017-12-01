package com.neoLync.bank.model;

import java.util.ArrayList;
import java.util.Date;

public class Client {
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String Adresse;
	private String Phone;
	private Date birthDate;
	private ArrayList<Account> accounts;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public ArrayList<Account> getAccounts() {
		if (accounts == null) accounts = new ArrayList<Account>();
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", Adresse=" + Adresse
				+ ", Phone=" + Phone + ", birthDate=" + birthDate + ", accounts=" + accounts + "]";
	}



}
