package banking.factory;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.factory.CustomerFactory;

public abstract class BankFactory extends CustomerFactory {
	public abstract AccountDefault createCheckingAccount(String accNumber);

	public abstract AccountDefault createSavingAccount(String accNumber);

	public CustomerDefault createCustomer(String name, String street, String city, String state, int zip, String email,
			String accountNo, String accType, int numEmps) {
		return null;
	}

	public CustomerDefault createCustomer(String name, String street, String city, String state, int zip, String email,
			String accountNo, String accType, String dob) {
		return null;
	}

}
