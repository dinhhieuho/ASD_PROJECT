package creditcard.account;

import java.time.LocalDate;

public class Bronze  extends CcardAccount {

	
	public Bronze(String cc_number, LocalDate exp_date) {
		super(cc_number, exp_date);
		// TODO Auto-generated constructor stub
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
