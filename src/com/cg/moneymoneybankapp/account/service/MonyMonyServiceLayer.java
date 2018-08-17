package com.cg.moneymoneybankapp.account.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.CurrentAccount;
import com.cg.bank.framework.account.pojo.SavingsAccount;
import com.cg.moneymoneybankapp.account.dao.MoneyMoneyBankCollection;

public class MonyMonyServiceLayer {

	MoneyMoneyBankCollection dataLayer = new MoneyMoneyBankCollection();
		
	
	public BankAccount createNewCurrentAccount(CurrentAccount createNewCurrentAccount) {
		return dataLayer.addBankAccount(createNewCurrentAccount);
		
	}

	public BankAccount createNewSavingsAccount(SavingsAccount createNewSavingsAccount) {
		return dataLayer.addBankAccount(createNewSavingsAccount);
	}

	public double depositAmount(int accountToBeDepsitedIn, double amount) {
		return dataLayer.depositAmount(accountToBeDepsitedIn, amount);
	}

	
	public Collection<BankAccount> getAllAccounts() {
		return dataLayer.getAllAccounts();
	}
	
	public boolean validateUser(int accountNumber) {
		
		return dataLayer.validateUser(accountNumber);
	}

	public BankAccount getAccountByAccountNumber(int accountNumberToBeSearched){
		return dataLayer.getAccountByAccountNumber(accountNumberToBeSearched);
	}

	public double performFundTransfer(int receipientAccountNumber, int donerAccountNumber,
			double amountToBeTransffered) {
		return dataLayer.performFundTransfer(receipientAccountNumber, donerAccountNumber, amountToBeTransffered);
	}

	public Map<Integer,Integer> withdrawWithDenomination(int accountNumber, double amountToBeWithdrawn) {
		return dataLayer.withdrawWithDenomination(accountNumber,amountToBeWithdrawn);
	}

	public void updateCustomer(int accountNumber, Map<String, Object> updatedMap) {
		BankAccount b = dataLayer.getAccountByAccountNumber(accountNumber);
		b.getAccountHolder().setDateOfBirth((LocalDate)updatedMap.get("dateOfBirth"));
		b.getAccountHolder().setContactNumber(Long.parseLong(updatedMap.get("contactNumber").toString()));
		b.getAccountHolder().setCustomerName((String) updatedMap.get("customerName"));
		b.getAccountHolder().setEmailId((String) updatedMap.get("emailId"));
	}
	
}
