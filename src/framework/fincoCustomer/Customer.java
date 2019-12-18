package framework.fincoCustomer;

import java.util.HashMap;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.fincoAccount.Account;
import framework.fincoEntry.Entry;

public class Customer implements FincoCustomer {

	private String name;
	private String street;
	private String city;
	private String state;
	private String email;
	private int zip;
	private HashMap<String, Account> accounts = new HashMap<String, Account>();

	public Customer(String name, String street, String city, String state, String email, int zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
	}

	@Override
	public Customer addAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
		return this;
	}

	@Override
	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	@Override
	public void sendEmail(String message) {
		System.out.println("Email Address: " + email + "\nEmail Message: " + message);

	}

	@Override
	public void debit(String accountNumber, double amount) throws AccountNotFoundException,BalanceInsufficientException {
		Account account = findAccount(accountNumber);
		if (account == null) {
			//negBalanceMesg();
			throw new AccountNotFoundException("Account Not Found");
		}
		if (account.getBalance() < amount) {
			throw new BalanceInsufficientException("Balance Insufficient");
		} else {
			double balanceLeft = account.getBalance() - amount;
			account.setBalance(balanceLeft);
			account.addEntry(new Entry(amount, "debited"));
		}

	}
	
	
	
	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = findAccount(accountNumber);
		if (account != null) {
			double balance = account.getBalance() + amount;
			account.setBalance(balance);
			account.addEntry(new Entry(amount, "credited"));
			printCustomerLog("Account name: "+name+" "+account);
		}else {
			throw new AccountNotFoundException("Account Not Found");
		}

	}

	public String getEmail() {
		return email;
	}

	public Account findAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}
	
	public String getName() {
		return name;
	}
	
	public HashMap<String, Account> getAccounts() {
		return accounts;
	}
	
	@Override
	public String toString() {
		return "{Name: "+name
				+ ",Street: "+street
				+ ",City: "+city
				+ ",State: "+state
				+ ",Email: "+email
				+ ",Zip: "+zip
				+ "}";
	}
	
	private void printCustomerLog(String message) {
		//System.out.println("Finco [INFO]: "+message);
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCustomerType() {
		return "Default";
	}
	public String negBalanceMesg() {
		return "Dear "+name+", your transaction has failed because you don't have enough balance";
	}

}
