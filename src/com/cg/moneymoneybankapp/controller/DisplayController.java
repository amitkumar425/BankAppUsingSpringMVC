package com.cg.moneymoneybankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import com.cg.moneymoneybankapp.account.service.MonyMonyServiceLayer;

@Controller
public class DisplayController {

	MonyMonyServiceLayer serviceLayer = new MonyMonyServiceLayer();
	
	
	@RequestMapping("NoAccountFound")
	public String noAccount() {
		return "NoAccountFound";
	}

	@RequestMapping("ViewAllCustomers")
	public String viewAllCustomer(HttpServletRequest request) {
		request.getSession().setAttribute("accountList", serviceLayer.getAllAccounts());
		return "ViewAllCustomers";
	}

	@RequestMapping("searchAccount")
	public String searchAccount(@RequestParam("accountNumber") String accountNumberToBeSearched,
			HttpServletRequest request) {

		request.getSession().setAttribute("accountFound",
				serviceLayer.getAccountByAccountNumber(Integer.parseInt(accountNumberToBeSearched)));

		return "ViewAccount";
	}

	@RequestMapping("update")
	public String updateRequest(@RequestParam("accountNumber") String accountNumber, HttpServletRequest request) {
		int accountIdToBeUpdated = Integer.parseInt(accountNumber);
		request.getSession().setAttribute("accountToBeUpdated",
				serviceLayer.getAccountByAccountNumber(accountIdToBeUpdated));

		return "UpdateCustomerForm";

	}

	@RequestMapping("writeUpdate")
	public String writeUpdate(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("customerName") String customerName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("dob") String dateOfBirth,
			HttpServletRequest request) {

		Map<String, Object> updatedMap = new HashMap<String, Object>();

		updatedMap.put("customerName", request.getParameter("customerName"));
		updatedMap.put("emailId", request.getParameter("email"));
		updatedMap.put("contactNumber", request.getParameter("phoneNumber"));

		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateOfBirth, formater);
		updatedMap.put("dateOfBirth", date);

		serviceLayer.updateCustomer(Integer.parseInt(accountNumber), updatedMap);

		return "ViewAllCustomers";
	}
}
