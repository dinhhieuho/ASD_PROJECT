package framework.factory;

import framework.account.AccountDefault;
import framework.customer.Customer;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.entry.Entry;
import framework.entry.EntryDefault;

public class CustomerFactory {

	private static DataAccess dataAccess = new DataAccessService();

	public static Customer createCustomer(String name, String street, String city, String state, int zip, String email,
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
