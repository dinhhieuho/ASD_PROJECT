package banking.customer;

import java.util.EmptyStackException;

import framework.account.Account;
import framework.customer.PersonDefault;
import framework.entry.Entry;

public class Person extends  PersonDefault{
	private String birthDate; // using string for now, will convert to localdate later
	private String ctype = "Person";

	public Person(String name, String street, String city, String state, int zip, String email, String birthDate) {
		super(name, street, city, state, email, zip);
		this.birthDate = birthDate;
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
			if (amount > 500) {
				String transtype = lastEntry.getTransType();
				String name = getName();
				String message = "Dear " + name + ", " + "your account(" + AccNum + ") has been " + transtype
						+ " with an amount of $" + amount;
				super.sendEmail(message);
			}

		} catch (EmptyStackException e) {

		}
	}

	@Override
	public String negBalanceMesg() {
		sendEmail(super.negBalanceMesg());
		return null;
	}

}
