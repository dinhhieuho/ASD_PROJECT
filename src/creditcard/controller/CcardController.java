package creditcard.controller;

import java.util.HashMap;
import java.util.Map;

import creditcard.account.CcardAccount;
import creditcard.customer.CustomerCcard;
import framework.controller.Controller;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public  class CcardController extends Controller{
	
	Map<String,CustomerCcard> customers = new HashMap<String,CustomerCcard>();
	
	public Map<String, CustomerCcard> loadAccounts(){
		return customers;
	}
	public void addCustomer(String name,CustomerCcard acc) {
		customers.put(name, acc);
	}
	
	public void deposit(String name, String accNum, double amount) throws AccountNotFoundException {
		customers.get(name).credit(accNum, amount);
	}
	
	public void charge(String name, String accNum, double amount) throws AccountNotFoundException, BalanceInsufficientException {
		customers.get(name).debit(accNum, amount);
	}

	public String report() {
		String billstring="";
		// generate the string for the monthly bill
		for(CustomerCcard customer : customers.values()) {
			for(CcardAccount acc : customer.getCcards().values()) {
				billstring += customer.toString();
				billstring += "CC number= "+acc.getCC_number()+"\r\n";
				billstring += "CC type= "+acc.toString()+"\r\n";
				billstring += "Previous balance = $ "+acc.getPrevious_balance()+"\r\n";
				billstring += "Total Credits = $ "+acc.getTotal_credits()+"\r\n";
				billstring += "Total Charges = $ "+acc.getTotal_charges()+"\r\n";
				billstring += "New balance = $ "+acc.computeNewBalance()+"\r\n";
				billstring += "Total amount due = $ "+acc.computeTotal_due()+"\r\n";		
				billstring += "\r\n";		
				billstring += "\r\n";
			}
		}
		return billstring;
	}
}
