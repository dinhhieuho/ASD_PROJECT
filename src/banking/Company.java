package banking;

import java.util.EmptyStackException;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoEntry.Entry;

public class Company extends Customer {

	private int nr_of_employees;
	private String ctype = "Company";

	public Company(String name, String street, String city, String state, int zip, String email, int numEmps) {
		super(name, street, city, state, email, zip);
		nr_of_employees = numEmps;
	}

	public String getCustomerType() {
		return this.ctype;
	}

	@Override
	public void sendEmail(String AccNum) {
		Account account = getAccounts().get(AccNum);
		try {
			Entry lastEntry = account.getEntry().peek();
			double amount = lastEntry.getAmount();
			//if(amount > )

		} catch (EmptyStackException e) {

		}
	}

}
