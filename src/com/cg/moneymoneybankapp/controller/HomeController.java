package com.cg.moneymoneybankapp.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		request.getSession().setAttribute("denomination",0);
		request.getSession().setAttribute("depositStatus", 0);
		request.getSession().setAttribute("deposit",0);
		request.getSession().setAttribute("fundTransferStatus",0);
		request.getSession().setAttribute("denominationStatus",0);
		return "Home";
	}
	
	@RequestMapping("AddNewAccount")
	public String addNewAccount() {
		return "AddNewAccount";
	}
	
	@RequestMapping("SearchAccount")
	public String searchAccount() {
		return "SearchAccount";
	}
	
	@RequestMapping("DepositForm")
	public String depositForm() {
		return "DepositForm";
	}	
	
	@RequestMapping("WithdrawForm")
	public String withdrawForm() {
		return "WithdrawForm";
	}	
	
	@RequestMapping("FundTransfer")
	public String fundTransfer() {
		return "FundTransfer";
	}
	
	@RequestMapping("AccountNotFound")
	public String accountNotFound() {
		return "AccountNotFound";
	}
	
}
