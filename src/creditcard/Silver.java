package creditcard;

import java.time.LocalDate;

public class Silver  extends CcardAccount{
	public Silver(String accNumber) {
		super(accNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Silver(String name, String cc_number, LocalDate exp_date) {
		super(name,  cc_number,  exp_date);
	}
	
	private final double X = 0.05;
	private final double Y = 0.1;
	

}
