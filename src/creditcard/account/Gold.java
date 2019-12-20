package creditcard.account;

import java.time.LocalDate;

public class Gold extends CcardAccount {
	
	
	public Gold(String cc_number, LocalDate exp_date) {
		super(cc_number, exp_date);
	}
	
	private final double X = 0.05;
	private final double Y = 0.1;
	
	
	
	@Override
	public double computeNewBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double computeTotal_due() {
		// TODO Auto-generated method stub
		return 0;
	}


}
