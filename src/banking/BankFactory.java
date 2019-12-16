package banking;

import framework.CustomerFactory;
import framework.FincoAccount;

public abstract class BankFactory extends CustomerFactory {
	public abstract FincoAccount createCheckingAccount();
	public abstract FincoAccount createSavingAccount();

}
