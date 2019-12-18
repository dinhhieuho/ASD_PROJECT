package banking;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoFactory.CustomerFactory;

public abstract class BankFactory extends CustomerFactory{
	public abstract Account createCheckingAccount(String accNumber);
	public abstract Account createSavingAccount(String accNumber);

}
