
package creditcard.account;

import java.time.LocalDate;

public class Bronze  extends CcardAccount {

	
	public Bronze(String cc_number, LocalDate exp_date,String accountType) {
		super(cc_number, exp_date);
		this.accountType = accountType;
		
	}
	private final double X = 0.05;
	private final double Y = 0.1;
	private String accountType;
	
	@Override
	
	public double computeNewBalance() {
		return 0;
	}
	@Override
	public double computeTotal_due() {
		return 0;
	}
	
	
	@Override
	public String getAccountType() {
		return accountType;
	}
	
	
}


