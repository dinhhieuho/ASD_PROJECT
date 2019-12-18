package banking;

import java.time.LocalDate;
import java.util.EmptyStackException;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoEntry.Entry;



public class Person extends Customer{
	private String birthDate; //using string for now, will convert to localdate later
	private String ctype = "Person";
	public Person(String name, String street, String city, String state, int zip, String email, String birthDate) {
		super(name, street, city, state, email, zip);
		this.birthDate = birthDate;
	}
	
	public String getCustomerType() {
		return this.ctype ;
	}
	
	@Override
	public void sendEmail(String AccNum) {
		Account account = getAccounts().get(AccNum);
		try {
			Entry lastEntry = account.getEntry().peek();
			double amount = lastEntry.getAmount();
			if(amount > 500) {
				super.sendEmail("Transaction");
			}

		} catch (EmptyStackException e) {

		}
	}

}
