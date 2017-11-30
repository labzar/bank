package com.neoLync.bank.services;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;

import com.neoLync.bank.model.Account;
import com.neoLync.bank.model.Client;

public class ClientServiceTest {

	public ClientService clientService = new ClientService();

	@Test
	public void testAddClient() throws ParseException {
		// Create client
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAdresse("11 rue xxx");
		c1.setPhone("0611-11-11-11");
		c1.setAccounts(new ArrayList<Account>());

		//Add the client
		clientService.add(c1);
		assertEquals(1, clientService.getClientlist().size());
	}

	@Test
	public void testDeleteClient() throws ParseException {
		// Create client
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAdresse("11 rue xxx");
		c1.setPhone("0611-11-11-11");
		c1.setAccounts(new ArrayList<Account>());

		Client c2 = new Client();
		c2.setId(2);
		c2.setFirstName("cc");
		c2.setLastName("cc");
		c2.setAge(19);
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c2.setAdresse("2 rue xxx");
		c2.setPhone("0611-11-11-22");
		c2.setAccounts(new ArrayList<Account>());

		//Add the client
		clientService.add(c1);
		clientService.add(c2);
		assertEquals(2, clientService.getClientlist().size());

		//Delete Client
		clientService.delete(c1);
		assertEquals(1, clientService.getClientlist().size());
		assertEquals("cc", clientService.getClientlist().get(0).getFirstName());
	}

	@Test
	public void testUpdateClient() throws ParseException {
		// Create client
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAdresse("11 rue xxx");
		c1.setPhone("0611-11-11-11");
		c1.setAccounts(new ArrayList<Account>());

		Client c2 = new Client();
		c2.setId(2);
		c2.setFirstName("cc");
		c2.setLastName("cc");
		c2.setAge(19);
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c2.setAdresse("2 rue xxx");
		c2.setPhone("0611-11-11-22");
		c2.setAccounts(new ArrayList<Account>());

		//Add the client
		clientService.add(c1);
		clientService.add(c2);
		assertEquals(2, clientService.getClientlist().size());
		assertEquals("aa", clientService.getClientlist().get(0).getFirstName());

		//Update Client
		c1.setFirstName("bb");
		clientService.update(c1);
		assertEquals("bb", clientService.getClientlist().get(0).getFirstName());
	}

	@Test
	public void testReadClient() throws ParseException {
		// Create client
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAdresse("11 rue xxx");
		c1.setPhone("0611-11-11-11");
		c1.setAccounts(new ArrayList<Account>());

		Client c2 = new Client();
		c2.setId(2);
		c2.setFirstName("cc");
		c2.setLastName("cc");
		c2.setAge(19);
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c2.setAdresse("2 rue xxx");
		c2.setPhone("0611-11-11-22");
		c2.setAccounts(new ArrayList<Account>());

		//Add the client
		clientService.add(c1);
		clientService.add(c2);
		
		// test if client Exist
		Optional<Client> cc = clientService.read(1);
		assertEquals("aa", cc.get().getFirstName());
		
		// test if client not Exist
		Optional<Client> cc2 = clientService.read(99);
		assertEquals(Optional.empty(), cc2);
	}
}
