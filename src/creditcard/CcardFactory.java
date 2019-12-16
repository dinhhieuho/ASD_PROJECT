package creditcard;

import framework.CustomerFactory;
import framework.FincoAccount;

public abstract class CcardFactory extends CustomerFactory {
	public abstract FincoAccount createGoldAccount();
	public abstract FincoAccount createSilverAccountt();
	public abstract FincoAccount createBronzeAccountt();

}
