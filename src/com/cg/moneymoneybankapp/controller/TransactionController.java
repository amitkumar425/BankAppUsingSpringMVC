package com.cg.moneymoneybankapp.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.moneymoneybankapp.account.service.MonyMonyServiceLayer;

@Controller
public class TransactionController {

	MonyMonyServiceLayer serviceLayer = new MonyMonyServiceLayer();

	@RequestMapping("depositIntoAccount")
	public String deposit(@RequestParam("accountNumber") String accountToBeDepsitedIn,
			@RequestParam("amountToBeDeposited") String amount, HttpServletRequest request) {

		request.getSession().setAttribute("deposit",
				serviceLayer.depositAmount(Integer.parseInt(accountToBeDepsitedIn), Double.parseDouble(amount)));
		return "DepositForm";
	}

	@RequestMapping("withdraw")
	public String withdraw(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amountToBeWithdrawn") String amountToBeWithdrawn, HttpServletRequest request) {

		request.getSession().setAttribute("denomination", serviceLayer
				.withdrawWithDenomination(Integer.parseInt(accountNumber), Double.parseDouble(amountToBeWithdrawn)));

		return "DenominationDisplay";

	}

	@RequestMapping("fundTransfer")
	public String fundTransfer(@RequestParam("fromAccountNumber") String donerAccountNumber,
			@RequestParam("toAccountNumber") String receipientAccountNumber,
			@RequestParam("amountToTransfer") String amountToBeTransffered, HttpServletRequest request) {

		
		double amountTransferred = serviceLayer.performFundTransfer(Integer.parseInt(receipientAccountNumber),
						Integer.parseInt(donerAccountNumber), Double.parseDouble(amountToBeTransffered));
		if(amountTransferred!=-1) {
			request.getSession().setAttribute("fundTransferStatus", 1);
			request.getSession().setAttribute("receipientAccountNumber", receipientAccountNumber);
			request.getSession().setAttribute("donerAccountNumber", donerAccountNumber);
			request.getSession().setAttribute("fundTransfer", amountTransferred);
		}else {
			request.getSession().setAttribute("fundTransferStatus", -1);
		}
		return "FundTransfer";

	}
}
