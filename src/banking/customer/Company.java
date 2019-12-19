package banking.customer;

import java.util.EmptyStackException;

import framework.account.Account;
import framework.customer.Customer;
import framework.customer.CustomerDefault;
import framework.customer.OrganizationDefault;
import framework.entry.Entry;

public class Company extends OrganizationDefault {

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
			String transtype = lastEntry.getTransType();
			String name = getName();
			String message = "Dear "+ name +", "+"your account("+AccNum+") has been "+transtype+" with an amount of $"+amount;
			super.sendEmail(message);

		} catch (EmptyStackException e) {

		}
	}

}
