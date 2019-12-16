package creditcard;

import java.time.LocalDate;
import java.util.List;

import framework.Account;
import framework.Entry;

public  abstract class CcardAccount extends  Account{
	private String cc_number;
	private LocalDate exp_date;
	private double lastMonthBalance;
	private List<Entry> entry;
	
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
}
