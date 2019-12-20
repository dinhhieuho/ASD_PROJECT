
package creditcard.account;

import java.time.LocalDate;

public class Silver extends CcardAccount {

	public Silver(String cc_number, LocalDate exp_date, String accountType) {
		super(cc_number, exp_date);
		this.accountType = accountType;
	}

	private final double X = 0.05;
	private final double Y = 0.1;
	private String accountType;

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

	@Override
	public String toString() {
		return "CC_number" + super.getCC_number() + "exp_date:";
	}

	@Override
	public String getAccountType() {
		return accountType;
	}

}
