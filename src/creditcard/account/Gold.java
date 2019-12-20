
package creditcard.account;

import java.time.LocalDate;

public class Gold extends CcardAccount {
	
	
	public Gold(String cc_number, LocalDate exp_date,String accountType) {
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
	public String toString() {
		return "CC_number"+super.getCC_number()+"exp_date:";
	}
	
	@Override
	public String getAccountType() {
		return accountType;
	}

}


