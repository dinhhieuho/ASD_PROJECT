package creditcard;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import framework.fincoAccount.Account;
import framework.fincoEntry.Entry;

public  abstract class CcardAccount extends  Account{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CcardAccount(String accNumber) {
		super(accNumber);
		// TODO Auto-generated constructor stub
	}
	
	public CcardAccount(String name, String cc_number, LocalDate exp_date, Address address) {
		super("");
		this.name = name;
		this.cc_number = cc_number;
		this.exp_date = exp_date;
		this.address = address;
	}

	private String name;
	private String cc_number;
	private LocalDate exp_date;
	private double lastMonthBalance;
	private double total_charges = 0;
	private double previous_balance = 0;
	private double total_credits = 0;
	private List<Entry> entry;
	
	private Address address;
	
	public void addCharge(double amount) {
		total_charges += amount;
	}
	public double getTotal_charges() {
		return total_charges;
	}
	public void setPrevious_balance(double amount) {
		previous_balance = amount;
	}
	public double getPrevious_balance() {
		return previous_balance;
	}
	public void pay(double amount) {
		total_credits += amount;
	}
	public double getTotal_credits() {
		return total_credits;
	}
	public void addEntry() {
		
	}
	public double getCurrentBalance() {
		return 0;
	}
	
	public double getLastMonthlyBalance() {
		return 0;
	}
	
	public double getTotalMonthlyCredit() {
		return 0;
	}
	
	public double getNewMonthlyBalance() {
		return 0;
	}
	
	public double getMonthlyAmountDue() {
		return 0;
	}
	
	public void notifyAccountHolder() {
		//return 0;
	}
	public String getName() {
		return name;
	}
	public String getCC_number(){
		return cc_number;
	}
	public LocalDate getExp_date() {
		return exp_date;
	}
	public Address getAddress() {
		return address;
	}
	public abstract double getNewBalance();
	public abstract double getTotal_due();
}
