package banking;

import java.time.LocalDate;

import framework.fincoCustomer.Customer;



public class Person extends Customer{
	public Person(String name, String street, String city, String state, int zip, String email, LocalDate birthDate) {
		super(name, street, city, state, email, zip);
		this.birthDate = birthDate;
	}

	private LocalDate birthDate;
}
