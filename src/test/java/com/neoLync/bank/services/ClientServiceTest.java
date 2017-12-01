package com.neoLync.bank.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.neoLync.bank.model.Account;
import com.neoLync.bank.model.Client;

public class ClientServiceTest {

	public ClientService clientService = new ClientService();
	public AccountService accountService = new AccountService();

	//========================================Test CRUD=================================

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
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1992"));
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
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1992"));
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
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1992"));
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

	//========================================Test link accounts to users as well=================================
	@Test
	public void testLinkAccountToClient() throws ParseException {
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

		//create Account
		Account ac1 = new Account(1, c1.getId(), 2200, new Date());
		Account ac2 = new Account(2, c1.getId(), 7200, new Date());
		c1.getAccounts().add(ac1);
		c1.getAccounts().add(ac2);

		clientService.add(c1);

		assertTrue(c1.getAccounts().size() == 2);
		assertTrue(clientService.getClientlist().size() == 1);

		assertTrue(clientService.getClientlist().get(0).getAccounts().get(0).getId() == 1);
	}

	//========================================Test  find all the accounts of a given user=================================
	@Test
	public void testFindAllAccountOfUser() throws ParseException {
		// Create clients
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAccounts(new ArrayList<Account>());

		Client c2 = new Client();
		c2.setId(2);
		c2.setFirstName("bb");
		c2.setLastName("b");
		c2.setAge(55);
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1992"));
		c2.setAccounts(new ArrayList<Account>());

		Client c3 = new Client();
		c3.setId(3);
		c3.setFirstName("cc");
		c3.setLastName("cc");
		c3.setAge(45);
		c3.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1993"));
		c3.setAccounts(new ArrayList<Account>());

		//create Account
		Account ac1 = new Account(1, c1.getId(), 2200, new Date());
		Account ac2 = new Account(2, c1.getId(), 7200, new Date());
		Account ac3 = new Account(3, c2.getId(), 4200, new Date());
		Account ac4 = new Account(4, c2.getId(), 6200, new Date());
		Account ac5 = new Account(5, c2.getId(), 6200, new Date());
		Account ac6 = new Account(6, c3.getId(), 2200, new Date());

		//Add Accounts
		accountService.add(ac1);
		accountService.add(ac2);
		accountService.add(ac3);
		accountService.add(ac4);
		accountService.add(ac5);
		accountService.add(ac6);
		
		List <Account> accountListCl1 =  accountService.findAllAccountOfUser(c1.getId());
		assertTrue(accountListCl1.size() == 2);
		assertTrue(accountListCl1.get(0).getOwnerId() == 1);
		assertTrue(accountListCl1.get(1).getOwnerId() == 1);
		
		List <Account> accountListCl2 =  accountService.findAllAccountOfUser(c2.getId());
		assertTrue(accountListCl2.get(0).getOwnerId() == 2);
		assertTrue(accountListCl2.get(1).getOwnerId() == 2);
		assertTrue(accountListCl2.size() == 3);
	}
	
	//========================================Test functionality to find the sum of balances of all the accounts of a given user =================================
	@Test
	public void testSumBalanceOfAllAccountOfUser() throws ParseException {
		// Create clients
		Client c1 = new Client();
		c1.setId(1);
		c1.setFirstName("aa");
		c1.setLastName("aa");
		c1.setAge(19);
		c1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1990"));
		c1.setAccounts(new ArrayList<Account>());

		Client c2 = new Client();
		c2.setId(2);
		c2.setFirstName("bb");
		c2.setLastName("b");
		c2.setAge(55);
		c2.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1992"));
		c2.setAccounts(new ArrayList<Account>());

		Client c3 = new Client();
		c3.setId(3);
		c3.setFirstName("cc");
		c3.setLastName("cc");
		c3.setAge(45);
		c3.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("11-01-1993"));
		c3.setAccounts(new ArrayList<Account>());

		//create Account
		Account ac1 = new Account(1, c1.getId(), 2200, new Date());
		Account ac2 = new Account(2, c1.getId(), 7200, new Date());
		Account ac3 = new Account(3, c2.getId(), 4200, new Date());
		Account ac4 = new Account(4, c2.getId(), 6200, new Date());
		Account ac5 = new Account(5, c2.getId(), 1200, new Date());
		Account ac6 = new Account(6, c3.getId(), 2200, new Date());

		//Add Accounts
		accountService.add(ac1);
		accountService.add(ac2);
		accountService.add(ac3);
		accountService.add(ac4);
		accountService.add(ac5);
		accountService.add(ac6);
		
		double someBalanceCl1 =  accountService.sumBalanceOfAllAccountOfUser(c1.getId());
		assertTrue(someBalanceCl1 == 2200 + 7200);
		
		double someBalanceCl2 =  accountService.sumBalanceOfAllAccountOfUser(c2.getId());
		assertTrue(someBalanceCl2 == 4200 + 6200 + 1200);
	}
}
