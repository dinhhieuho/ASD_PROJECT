package framework;
import java.util.ArrayList;
import java.util.List;

public class Customer implements FincoCustomer {
	private String name;
	private String street;
	private String city;
	private String state;
	private String email;
	private int zip;
	private List<Account> accs = new ArrayList<Account>();
	
	public Customer(String name, String street, String city, String state, int zip, String email) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
	}

	
	public void addAccount(Account acc) {
		accs.add(acc);
	}
	
	public void removeAccount() {
		
	}
	
	public void sendEmail() {
		
	}
}
