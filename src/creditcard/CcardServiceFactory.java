package creditcard;

import java.time.LocalDate;
import java.util.List;

import framework.fincoAccount.Account;
import framework.fincoAccount.FincoAccount;
import framework.fincoEntry.Entry;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public CcardAccount createGoldAccount(String name, String cc_number, LocalDate exp_date, Address address) {
		return new Gold(name, cc_number, exp_date, address);
	}

	@Override
	public CcardAccount createSilverAccountt(String name, String cc_number, LocalDate exp_date, Address address) {
		// TODO Auto-generated method stub
		return new Silver(name, cc_number, exp_date, address);
	}

	@Override
	public CcardAccount createBronzeAccountt(String name, String cc_number, LocalDate exp_date, Address address) {
		// TODO Auto-generated method stub
		
		return new Bronze(name, cc_number, exp_date, address);
	}

	

}
