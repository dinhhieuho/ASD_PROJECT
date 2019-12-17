package creditcard;

import framework.fincoAccount.FincoAccount;
import framework.fincoFactory.CustomerFactory;

public abstract class CcardFactory extends CustomerFactory {
	public abstract FincoAccount createGoldAccount(String number);
	public abstract FincoAccount createSilverAccount(String number);
	public abstract FincoAccount createBronzeAccount(String number);
}
