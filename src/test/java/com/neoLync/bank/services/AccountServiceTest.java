package com.neoLync.bank.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.neoLync.bank.model.Account;

public class AccountServiceTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	public AccountService accountService = new AccountService();

	//===============================================Test CRUD===============================================
	@Test
	public void testAddAccount() {

		// Create Account
		Account ac1 = new Account(1, 11, 2200, new Date());

		//Add Account
		accountService.add(ac1);
		assertEquals(1, accountService.getAccountList().size());
	}


	@Test
	public void testReadAccount() {
		// Create Account
		Account ac1 = new Account(1, 11, 2200, new Date());
		Account ac2 = new Account(2, 22, 2300, new Date());
		Account ac3 = new Account(3, 22, 8200, new Date());

		//Add Accounts
		accountService.add(ac1);
		accountService.add(ac2);
		accountService.add(ac3);
		assertEquals(3, accountService.getAccountList().size());

		// test if Account Exist
		Optional<Account> cc = accountService.read(1);
		assertTrue(2200 == cc.get().getBalance());
	}

	@Test
	public void testDeleteAccount() {
		// Create Account
		Account ac1 = new Account(1, 11, 2200, new Date());
		Account ac2 = new Account(2, 22, 2300, new Date());
		Account ac3 = new Account(3, 22, 8200, new Date());

		//Add Accounts
		accountService.add(ac1);
		accountService.add(ac2);
		accountService.add(ac3);
		assertEquals(3, accountService.getAccountList().size());

		// Delete Account ac2
		Optional<Account> acc = accountService.read(2);
		assertTrue(2300 == acc.get().getBalance());
		accountService.delete(ac2);
		assertEquals(2, accountService.getAccountList().size());

		// test if deleted Account Exist
		assertEquals(Optional.empty(), accountService.read(2));
	}

	@Test
	public void testUpdateAccount() {
		// Create Account
		Account ac1 = new Account(1, 11, 2200, new Date());
		Account ac2 = new Account(2, 22, 2300, new Date());

		//Add Accounts
		accountService.add(ac1);
		accountService.add(ac2);

		//update ac2
		accountService.update(new Account(2, 33, 2400, new Date()));

		// test update
		assertTrue(2400 == accountService.read(2).get().getBalance());
	}

	//========================================Test withdraw and deposit money in bank accounts=================================

	@Test
	public void testWithdraw() throws Exception {
		Account ac1 = new Account(1, 11, 2200, new Date());

		// test update
		assertTrue(2200 == ac1.getBalance());

		ac1.withdraw(200);

		// test withdraw
		assertTrue(2000 == ac1.getBalance());
	}
	
	@Test
	public void testWithdrawWithNotEnoughBalance() throws Exception {
		Account ac1 = new Account(1, 11, 2200, new Date());

		// test update
		assertTrue(2200 == ac1.getBalance());

		
		//test type
        thrown.expect(Exception.class);

		//test message
        thrown.expectMessage(is("You don't have enough balance"));
        
        ac1.withdraw(4000);
	}

	@Test
	public void testDeposit() {
		Account ac1 = new Account(1, 11, 2200, new Date());

		// test update
		assertTrue(2200 == ac1.getBalance());

		ac1.deposit(200);

		// test withdraw
		assertTrue(2400 == ac1.getBalance());
	}
	
}
