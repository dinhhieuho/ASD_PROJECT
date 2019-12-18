package creditcard;

import java.time.LocalDate;

public class Bronze  extends CcardAccount {

	public Bronze(String accNumber) {
		super(accNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Bronze(String name, String cc_number, LocalDate exp_date) {
		super(name,  cc_number,  exp_date);
	}
	private final double X = 0.05;
	private final double Y = 0.1;
}
