package framework.customer;

import java.util.HashMap;
import java.util.Map.Entry;

import framework.account.AccountDefault;
import framework.entry.EntryDefault;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.observable.Observable;
import framework.ui.TableView;

public class CustomerDefault implements Customer {

	private String name;
	private String street;
	private String city;
	private String state;
	private String email, alert;
	private int zip;
	private Observable<TableView> subject;
	private HashMap<String, AccountDefault> accounts = new HashMap<String, AccountDefault>();

	public CustomerDefault(String name, String street, String city, String state, String email, int zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
	}

	@Override
	public CustomerDefault addAccount(AccountDefault account) {
		accounts.put(account.getAccountNumber(), account);
		return this;
	}

	@Override
	public void removeAccount(AccountDefault account) {
		accounts.remove(account);
	}

	@Override
	public void sendEmail(String message) {
		alert = message;
		this.subject.setState(message);
		System.out.println("Email Address: " + email + "\nEmail Message: " + message);

	}

	@Override
	public void debit(String accountNumber, double amount)
			throws AccountNotFoundException, BalanceInsufficientException {
		AccountDefault account = findAccount(accountNumber);
		if (account == null) {
			throw new AccountNotFoundException("Account Not Found");
		}
		if (account.getBalance() < amount) {
			throw new BalanceInsufficientException("Balance Insufficient");
		} else {
			double balanceLeft = account.getBalance() - amount;
			account.setBalance(balanceLeft);
			account.addEntry(new EntryDefault(amount, "debited"));
			if(subject != null) {
				subject.setState();
			}
		}

	}

	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		AccountDefault account = findAccount(accountNumber);
		if (account != null) {
			double balance = account.getBalance() + amount;
			account.setBalance(balance);
			account.addEntry(new EntryDefault(amount, "credited"));
		} else {
			throw new AccountNotFoundException("Account Not Found");
		}

		if(subject != null) {
			subject.setState();
		}
	}

	public String getEmail() {
		return email;
	}

	public AccountDefault findAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}

	public String getName() {
		return name;
	}

	public HashMap<String, AccountDefault> getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		printCustomerReport();
		return "{Name: " + name + ",Street: " + street + ",City: " + city + ",State: " + state + ",Email: " + email
				+ ",Zip: " + zip + "}";
	}

	public String getCity() {
		return city;
	}

	public String getCustomerType() {
		return "Default";
	}

	public String negBalanceMesg() {
		return null;
	}

	public String printCustomerReport() {
		String message = "";
		for(Entry<String, AccountDefault> entry : accounts.entrySet()) {
			AccountDefault account = entry.getValue();
			message = name + " | " + account.getAccountNumber() + " | " + account.getBalance()+" | "+account.getAccountType();
		}
		//subject.setState(message);
		return message;
	}
	
	public void setSubject(Observable<TableView> subject) {
		this.subject = subject;
	}
	
	public Observable<TableView> getSubject() {
		return  subject;
	}
}
