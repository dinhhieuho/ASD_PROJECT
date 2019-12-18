package creditcard;

import java.time.LocalDate;

public class Gold extends CcardAccount {
	
	private final double MI = 0.06;
	private final double MP = 0.1;
	
	public Gold(String accNumber) {
		super(accNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Gold(String name, String cc_number, LocalDate exp_date, Address address) {
		super(name,  cc_number,  exp_date, address);
	}
	private final double X = 0.05;
	private final double Y = 0.1;
	@Override
	public String toString() {
		return "Gold";
	}
	public double getNewBalance() {
		double new_balance = getPrevious_balance() - getTotal_credits() 
				+ getTotal_charges() + MI*(getPrevious_balance() - getTotal_credits());
		
		return new_balance;
	}
	public double getTotal_due() {
		return getNewBalance()*MP;
	}
}
