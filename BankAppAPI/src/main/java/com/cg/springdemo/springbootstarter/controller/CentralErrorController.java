package com.cg.springdemo.springbootstarter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.springdemo.springbootstarter.exceptions.AccountNotFoundException;
import com.cg.springdemo.springbootstarter.exceptions.InvalidAccountNumberException;
import com.cg.springdemo.springbootstarter.exceptions.InvalidAccountOrAmountException;
import com.cg.springdemo.springbootstarter.exceptions.InvalidAmountException;
import com.cg.springdemo.springbootstarter.exceptions.NoAccountFoundException;

@ControllerAdvice
public class CentralErrorController {
	private ErrorResponse errorResponse = new ErrorResponse();

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAccountNotFoundError(AccountNotFoundException e) {
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoAccountFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoAccountFoundError(NoAccountFoundException e) {
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidAccountNumberException.class)
	public ResponseEntity<ErrorResponse> handleInvalidAccountNumberException(InvalidAccountNumberException e) {
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidAmountException.class)
	public ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException e) {
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidAccountOrAmountException.class)
	public ResponseEntity<ErrorResponse> handleInvalidAccountOrAmountException(InvalidAccountOrAmountException e) {
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
