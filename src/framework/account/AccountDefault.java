package framework.account;

import java.util.Stack;

import framework.entry.Entry;

public class AccountDefault implements Account {
	private double balance;
	private String acctype = "Default";
	
	private String accountNumber;
	
	private Stack<Entry> entries = new Stack<Entry>();
	
	public AccountDefault(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public void addEntry(Entry entry) {
		entries.add(entry);
	}	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account no: "+accountNumber+" Last Entry :"+entries == null? "": ""+entries.peek();
	}

	@Override
	public void addInterest() {
		
	}
	public String  getAccountType() {
		return this.acctype;
	}

	@Override
	public Stack<Entry> getEntry() {
		
		return this.entries;
	}
}
