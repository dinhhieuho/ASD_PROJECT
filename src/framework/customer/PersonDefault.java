package framework.customer;

public class PersonDefault extends CustomerDefault implements Person{
	
	public PersonDefault(String name, String street, String city, 
			String state, String email, int zip) {
		super(name, street, city, state, email, zip);
	}


	private OrganizationDefault organization;
	
	
	
}
