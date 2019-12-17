package banking;

import framework.Customer;

public class Company extends Customer{
	public Company(String name, String street, String city, String state, int zip, String email) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
	}

	private int nr_of_employees;

}
