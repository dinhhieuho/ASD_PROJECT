
package creditcard.account;

import java.time.LocalDate;

import framework.account.AccountDefault;

public abstract class CcardAccount extends AccountDefault {

	public CcardAccount(String cc_number, LocalDate exp_date) {
		super(cc_number);
		this.cc_number = cc_number;
		this.exp_date = exp_date;
	}

	private String cc_number;
	private LocalDate exp_date;
	// private double lastMonthBalance;
	private double total_charges = 0;
	private double previous_balance = 0;
	private double total_credits = 0;

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

	public String getCC_number() {
		return cc_number;
	}

	public LocalDate getExp_date() {
		return exp_date;
	}
	
	

	public abstract double computeNewBalance();

	public abstract double computeTotal_due();
	
	public abstract String getAccountType();


}
