package banking;

import java.time.LocalDate;

import framework.fincoCustomer.Customer;



public class Person extends Customer{
	public Person(String name, String street, String city, String state, int zip, String email) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
	}

	private LocalDate birthDate;
}
