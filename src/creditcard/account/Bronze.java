package creditcard.account;

import java.time.LocalDate;

public class Bronze  extends CcardAccount {
	
	private final double MI = 0.1;
	private final double MP = 0.14;
	
	public Bronze(String cc_number, LocalDate exp_date) {
		super(cc_number,  exp_date);
	}
	private final double X = 0.05;
	private final double Y = 0.1;
	
	@Override
	public String toString() {
		return "Bronze";
	}
	
	//new balance = previous balance – total credits + total charges + MI * (previous balance
		//	– total credits) 
	public double computeNewBalance() {
		double new_balance = getPrevious_balance() - getTotal_credits() 
				+ getTotal_charges() + MI*(getPrevious_balance() - getTotal_credits());
		
		return new_balance;
	}
	//total due = MP * new balance 
	public double computeTotal_due() {
		return computeNewBalance()*MP;
	}
}
