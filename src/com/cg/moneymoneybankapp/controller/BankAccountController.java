package com.cg.moneymoneybankapp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.moneymoneybankapp.account.service.MonyMonyServiceLayer;
import com.cg.moneymoneybankapp.factory.MMBankFactory;



@Controller
public class BankAccountController {

	Map<String, Object> accountDetails = new HashMap<>();
	MonyMonyServiceLayer serviceLayer = new MonyMonyServiceLayer() ;
	MMBankFactory bankFactory = new MMBankFactory();
	
	public void setServiceLayer(MonyMonyServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}
	public void setBankFactory(MMBankFactory bankFactory) {
		this.bankFactory = bankFactory;
	}



	@RequestMapping("BankAccountController")
	public String createAccount(@RequestParam("customerName") String accountHolderName,
			@RequestParam("dateOfBirth") String dateOfBirth,@RequestParam("contactNumber") String contactNumber,
			@RequestParam("nationality") String nationality,@RequestParam("gender") String gender,
			@RequestParam("emailID") String emailID,@RequestParam("houseNo") String houseNo,
			@RequestParam("street") String street,@RequestParam("city") String city,
			@RequestParam("state") String state,@RequestParam("pinCode") String pinCode,
			@RequestParam("accountType") String accountType,@RequestParam("odLimit") String odLimit,
			@RequestParam("isSalaried") String salary,@RequestParam("curbalance") String curbalance,
			@RequestParam("savNotbalance") String savNotbalance,@RequestParam("savSalbalance") String savSalbalance,Model model) {
		
		accountDetails.put("accountHolderName", accountHolderName);
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateOfBirth, formater);
		accountDetails.put("dateOfBirth", date);
		
		accountDetails.put("contactNumber", contactNumber);
		
		accountDetails.put("nationality", nationality);
		
		accountDetails.put("gender", gender);
		
		accountDetails.put("emailID", emailID);
		
		accountDetails.put("houseNo", houseNo);
		
		accountDetails.put("street", street);
		
		accountDetails.put("city", city);
		
		accountDetails.put("state", state);
		
		accountDetails.put("pinCode", pinCode);
		
		accountDetails.put("accountType", accountType);
		
		if(accountType.equals("savingAccount")) {
			
			if(salary.equals("salaried")) {
				accountDetails.put("accountBalance",savSalbalance);
				accountDetails.put("salary", true);
			}
			else {
				accountDetails.put("accountBalance",savNotbalance);
				accountDetails.put("salary", false);
			}
			model.addAttribute("createdAccount", serviceLayer.createNewSavingsAccount(bankFactory.createNewSavingsAccount(accountDetails)));
		}
		else {
			accountDetails.put("accountBalance",curbalance);
			accountDetails.put("odLimit", odLimit);
			model.addAttribute("createdAccount",serviceLayer.createNewCurrentAccount(bankFactory.createNewCurrentAccount(accountDetails)));
		}
		return "Success";
	}
	
}
