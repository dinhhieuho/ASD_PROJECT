package creditcard;

import framework.fincoAccount.FincoAccount;
import framework.fincoFactory.CustomerFactory;

public abstract class CcardFactory extends CustomerFactory {
	public abstract FincoAccount createGoldAccount();
	public abstract FincoAccount createSilverAccountt();
	public abstract FincoAccount createBronzeAccountt();

}
