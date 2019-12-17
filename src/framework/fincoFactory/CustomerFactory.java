package framework.fincoFactory;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoEntry.Entry;

public class CustomerFactory implements FincoFactory {

	public Customer createCustomer(String name, String street, String city, String state, int zip, String email) {
		Customer customer = new Customer(name, street, city, state, email, zip);
		return customer.addAccount(createAccount());
	}

	public Entry createEntry(double amount) {
		return new Entry(amount);
	}

	public Account createAccount() {
		return new Account();
	}

}
