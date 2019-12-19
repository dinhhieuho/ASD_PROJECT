package framework.factory;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.entry.Entry;
import framework.entry.EntryDefault;

public class CustomerFactory {

	public CustomerDefault createCustomer(String name, String street, String city, String state, int zip, String email,
			String accountNo) {
		CustomerDefault customer = new CustomerDefault(name, street, city, state, email, zip);
		return customer.addAccount(createAccount(accountNo));
	}

	public static Entry createEntry(double amount) {
		return new EntryDefault(amount);
	}

	public static AccountDefault createAccount(String accountNo) {
		return new AccountDefault(accountNo);
	}

}
