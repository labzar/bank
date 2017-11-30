package com.neoLync.bank.services;

import java.util.LinkedList;

import com.neoLync.bank.model.Client;

public class ClientService {

	private LinkedList<Client> clientlist;

	public LinkedList<Client> getClientlist() {
		return clientlist;
	}

	public void setClientlist(LinkedList<Client> clientlist) {
		this.clientlist = clientlist;
	}

	public Client add(Client c) {
		clientlist.add(c);
		return c;
	}

	public Boolean delete(Client c) {
		return clientlist.remove(c);
	}

	public void update(Client cl) {
		clientlist.forEach(clx -> {
			if(cl.getId() == clx.getId()) {
				clx.setAccounts(cl.getAccounts());
				clx.setAdresse(cl.getAdresse());
				clx.setAge(cl.getAge());
				clx.setBirthDate(cl.getBirthDate());
				clx.setFirstName(cl.getFirstName());
				clx.setLastName(cl.getLastName());
				clx.setPhone(cl.getPhone());
			}
		});
	}
	
	public void read() {
		clientlist.forEach(System.out::println);
	}

}
