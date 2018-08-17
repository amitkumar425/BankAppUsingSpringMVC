//This class implements the class BankFactory.
//It overrides the the methods createNewCurrentAccount() and createNewSavingsAccount() of class BankFactory.

package com.cg.moneymoneybankapp.factory;

import java.time.LocalDate;
import java.util.Map;
import com.cg.bank.framework.account.pojo.CurrentAccount;
import com.cg.bank.framework.account.pojo.SavingsAccount;
import com.cg.bank.framework.factory.BankFactory;
import com.cg.moneymoneybankapp.account.pojo.MMBankCurrentAccount;
import com.cg.moneymoneybankapp.account.pojo.MMBankCustomer;
import com.cg.moneymoneybankapp.account.pojo.MMBankCustomerAddress;
import com.cg.moneymoneybankapp.account.pojo.MMBankSavingsAccount;

public class MMBankFactory extends BankFactory {
	
	MMBankCurrentAccount mmBankCurrentAccount;
	MMBankSavingsAccount mmBankSavingAccount;
	MMBankCustomer mmBankCustomer;
	MMBankCustomerAddress mmBankCustomerAddress;

	@Override
	public CurrentAccount createNewCurrentAccount(Map<String, Object> map) {
		mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(), map.get("street").toString(),
				map.get("city").toString(), map.get("state").toString(), Integer.parseInt(map.get("pinCode").toString()));

		mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(), Long.parseLong(map.get("contactNumber").toString()),
				 map.get("emailID").toString(), (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress, map.get("nationality").toString(),
				map.get("gender").toString());

		mmBankCurrentAccount = new MMBankCurrentAccount(mmBankCustomer, Double.parseDouble(map.get("accountBalance").toString()),
				Double.parseDouble(map.get("odLimit").toString()), map.get("accountType").toString());
		return mmBankCurrentAccount;
	}

	@Override
	public SavingsAccount createNewSavingsAccount(Map<String, Object> map) {
			
			mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(),
					map.get("street").toString(), map.get("city").toString(), map.get("state").toString(),
					 Integer.parseInt(map.get("pinCode").toString()));
			
			mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(),
					Long.parseLong(map.get("contactNumber").toString()),  map.get("emailID").toString(), (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress,
					map.get("nationality").toString(), map.get("gender").toString());
			mmBankSavingAccount = new MMBankSavingsAccount(mmBankCustomer, Double.parseDouble(map.get("accountBalance").toString()),
					(boolean) map.get("salary"), map.get("accountType").toString());
			
		return mmBankSavingAccount;
	}

}
