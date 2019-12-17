package banking;

import framework.fincoAccount.FincoAccount;
import framework.fincoFactory.CustomerFactory;

public abstract class BankFactory extends CustomerFactory {
	public abstract FincoAccount createCheckingAccount();
	public abstract FincoAccount createSavingAccount();

}
