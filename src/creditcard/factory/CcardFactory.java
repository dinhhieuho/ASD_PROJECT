
package creditcard.factory;

import creditcard.account.CcardAccount;
import framework.factory.CustomerFactory;

public abstract class CcardFactory extends CustomerFactory {
	public abstract CcardAccount createGoldAccount(String accountNo);

	public abstract CcardAccount createSilverAccount(String accountNo);

	public abstract CcardAccount createBronzeAccount(String accountNo);

}
