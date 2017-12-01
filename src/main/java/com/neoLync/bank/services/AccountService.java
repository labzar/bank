package com.neoLync.bank.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.neoLync.bank.model.Account;

public class AccountService {
	private List<Account> accountList = new LinkedList<Account>();

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public Account add(Account ac) {
		accountList.add(ac);
		return ac;
	}

	public Boolean delete(Account ac) {
		return accountList.remove(ac);
	}

	public void update(Account ac) {
		accountList.forEach(acx -> {
			if(ac.getId() == acx.getId()) {
				acx.setBalance(ac.getBalance());
				acx.setOwnerId(ac.getOwnerId());
			}
		});
	}

	public Optional<Account> read(long id) {
		return accountList.stream()
				.filter(ac -> ac.getId() == id)
				.findFirst();
	}

	public void showList() {
		accountList.forEach(System.out::println);
	}

	public List<Account> findAllAccountOfUser(long id) {
		return accountList.stream()
        .filter(line -> line.getOwnerId() == id)
        .collect(Collectors.toList());
	}

	public double sumBalanceOfAllAccountOfUser(long id) {
		int sum = 0;
		List <Account> filtredList = accountList.stream()
        .filter(line -> line.getOwnerId() == id)
        .collect(Collectors.toList());
		
		for (Account account : filtredList) {
			sum += account.getBalance();
		}
		
		return sum;
	}
}
