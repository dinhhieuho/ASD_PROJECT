package banking;

import java.time.LocalDate;

import framework.fincoCustomer.Customer;



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

}
