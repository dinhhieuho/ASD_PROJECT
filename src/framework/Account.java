package framework;

public class Account implements FincoAccount {
	private int accNumber;
	private double balance;
	private Entry entry;
	
	public Account(int accNumber) {
		this.accNumber = accNumber;
	}
	
	public int getAccNumber() {
		return accNumber;
	}
	
	public double getBalance() {
		return balance;
	}
}
