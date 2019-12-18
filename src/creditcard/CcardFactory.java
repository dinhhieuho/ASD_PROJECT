package creditcard;

import java.time.LocalDate;
import java.util.List;

import framework.fincoAccount.FincoAccount;
import framework.fincoEntry.Entry;
import framework.fincoFactory.CustomerFactory;

public abstract class CcardFactory extends CustomerFactory {
	public abstract FincoAccount createGoldAccount(String name, String cc_number, LocalDate exp_date, Address address);
	public abstract FincoAccount createSilverAccountt(String name, String cc_number, LocalDate exp_date, Address address);
	public abstract FincoAccount createBronzeAccountt(String name, String cc_number, LocalDate exp_date, Address address);

}
