package creditcard;

import java.io.Serializable;

public class Address implements Serializable {
	private String street;
	private String city;
	private String state;
	private String zip;
	public Address(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
}
