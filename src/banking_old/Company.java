package banking_old;

import framework.fincoCustomer.Customer;

public class Company extends Customer{
	
	private int nr_of_employees;
	
	public Company(String name, String street, String city, String state, int zip, String email, int numEmps) {
		super(name, street, city, state, email, zip);
		nr_of_employees = numEmps;
	}


}
