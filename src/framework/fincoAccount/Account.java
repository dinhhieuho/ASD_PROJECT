package framework.fincoAccount;

import java.util.Stack;

import framework.fincoEntry.Entry;

public class Account implements FincoAccount {
	private double balance;
	
	private String accountNumber;
	
	private Stack<Entry> entries = new Stack<Entry>();
	
	public Account(String accountNumber) {
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
}
