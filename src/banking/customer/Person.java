package banking.customer;

import java.util.EmptyStackException;

import framework.account.Account;
import framework.customer.CustomerDefault;
import framework.customer.PersonDefault;
import framework.entry.Entry;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class Person extends  CustomerDefault{
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
		super.sendEmail("Dear " + super.getName() + ", your transaction has failed because you don't have enough balance");
		return null;
	}
	
	@Override
	public void debit(String accountNumber, double amount)
			throws AccountNotFoundException, BalanceInsufficientException {
		try {
			super.debit(accountNumber, amount);
		}
		catch(AccountNotFoundException | BalanceInsufficientException e) {
			negBalanceMesg();
			 throw new BalanceInsufficientException("Insufficient Balance");
		}
		sendEmail(accountNumber);

	}
	
	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		super.credit(accountNumber, amount);
		sendEmail(accountNumber);
	}

}
