package creditcard;

import java.time.LocalDate;
import java.util.List;

import framework.fincoAccount.FincoAccount;
import framework.fincoEntry.Entry;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public FincoAccount createGoldAccount(String name, String cc_number, LocalDate exp_date) {
		FincoAccount ccard = new Gold(name, cc_number, exp_date);
		return ccard;
	}

	@Override
	public FincoAccount createSilverAccountt(String name, String cc_number, LocalDate exp_date) {
		// TODO Auto-generated method stub
		return new Silver(name, cc_number, exp_date);
	}

	@Override
	public FincoAccount createBronzeAccountt(String name, String cc_number, LocalDate exp_date) {
		// TODO Auto-generated method stub
		return new Bronze(name, cc_number, exp_date);
	}

	

}
