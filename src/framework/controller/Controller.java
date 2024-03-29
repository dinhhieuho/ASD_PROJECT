package framework.controller;

import java.util.List;
import java.util.Optional;

import creditcard.customer.CustomerCcard;
import creditcard.dataacess.CardDataAccess;
import framework.customer.Customer;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class Controller {

	private DataAccess dataAccess;

	public Controller(DataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}

	public  void addCustomer(CustomerDefault customer) {
		// perform some logic before saving
		dataAccess.addCustomer(customer);

	}

	public String debit(double amount, String accountNumber) {
		String response = null;
		Optional<CustomerDefault> customer = dataAccess.findAccountByAccountNumber(accountNumber);

		if (customer.isPresent()) {
			try {
				customer.get().debit(accountNumber, amount);
			} catch (AccountNotFoundException | BalanceInsufficientException e) {

				response = "Insufficient Balance";
			}
		} else
			response = "Account Not Found";
		return response;
	}

	public String credit(double amount, String accountNumber) {

		String response = null;
		Optional<CustomerDefault> customer = dataAccess.findAccountByAccountNumber(accountNumber);

		if (customer.isPresent()) {
			try {
				customer.get().credit(accountNumber, amount);

			} catch (AccountNotFoundException e) {

				response = "Account Not Found"; // not reached
			}
		} else
			response = "Account Not Found";
		return response;
	}

	public void generateReport() {
		String message = "Account Report\nname|Account Number|Balance|AccountType";
		List<CustomerDefault> customer = dataAccess.findAll();
		//System.out.println();
		//customer.forEach(CustomerDefault::printCustomerReport);
		for(CustomerDefault c : customer) {
			message += "\n"+c.printCustomerReport();
		}
		if(!customer.isEmpty()) {
			customer.get(0).getSubject().setState(message);
		}
	}

	public List<CustomerDefault> loadAccounts() {
		return dataAccess.findAll();
	}

}
