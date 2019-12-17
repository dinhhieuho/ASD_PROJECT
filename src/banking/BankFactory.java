package banking;

import framework.fincoAccount.FincoAccount;
import framework.fincoFactory.CustomerFactory;

public abstract class BankFactory extends CustomerFactory {

	public BankFactory() {
		
	}
	public abstract FincoAccount createCheckingAccount(String number);
	public abstract FincoAccount createSavingAccount(String number);
}
