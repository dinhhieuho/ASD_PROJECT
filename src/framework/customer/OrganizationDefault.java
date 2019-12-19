package framework.customer;

import java.util.ArrayList;
import java.util.List;

import framework.exceptions.AccountNotFoundException;

public class OrganizationDefault extends CustomerDefault implements Organization {
	
	public OrganizationDefault(String name, String street, String city, String state, String email, int zip) {
		super(name, street, city, state, email, zip);
	}

	private List<PersonDefault> person = new ArrayList<PersonDefault>();

	
	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		super.credit(accountNumber, amount);
		System.out.println("Dear valued Customer, Transaction has occured in your account. Account Number :"+accountNumber);
	}
	

}
