package framework.fincoFactory;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoEntry.Entry;

public class CustomerFactory implements FincoFactory {

	public Customer createCustomer(String name, String street, String city, String state, int zip, String email,String accountNo) {
		Customer customer = new Customer(name, street, city, state, email, zip);
		return customer.addAccount(createAccount(accountNo));
	}

	public Entry createEntry(double amount) {
		return new Entry(amount);
	}

	public Account createAccount(String accountNo) {
		return new Account(accountNo);
	}

}
