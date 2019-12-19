package framework.controller;

import java.util.Optional;

import framework.customer.Customer;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class Controller {
	
	private  DataAccess dao;
	public Controller(DataAccess dao) {
		this.dao = dao;
	}
	public void addCustomer(CustomerDefault customer) {
		//perform some logic before saving
		dao.addCustomer(customer);
	}
	public String debit(double amount, String accountNumber) {
		String response = null;
		Optional<CustomerDefault> customer = dao.findAccountByAccountNumber(accountNumber);
		
		if(customer.isPresent()) {
			try {
				customer.get().debit(accountNumber, amount);
			} 
			catch (AccountNotFoundException | BalanceInsufficientException e) {
				
				response = "Insufficient Balance";
			}
		}
		else
			response = "Account Not Found";
		return response;
	}

	public String credit(double amount, String accountNumber) {

		String response = null;
		Optional<CustomerDefault> customer = dao.findAccountByAccountNumber(accountNumber);
		
		if(customer.isPresent()) {
			try {
				customer.get().credit(accountNumber, amount);
			} 
			catch (AccountNotFoundException e) {
				
				response = "Account Not Found"; //not reached
			}
		}
		else
			response = "Account Not Found";
		return response;
	}

	public void generateReport() {

	}
}
