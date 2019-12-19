package creditcard.factory;

import java.time.LocalDate;

import creditcard.account.Bronze;
import creditcard.account.Gold;
import creditcard.account.Silver;
import creditcard.customer.CustomerCcard;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public CustomerCcard createGoldAccount(String name, String street, String city, String state, int zip, String email,
			String cc_number, LocalDate exp_date) {
		// TODO Auto-generated method stub
		CustomerCcard customer = new CustomerCcard(name, street, city, state, email, zip);
		customer.addAccount(new Gold(cc_number, exp_date));
		return customer;
	}

	@Override
	public CustomerCcard createSilverAccountt(String name, String street, String city, String state, int zip,
			String email, String cc_number, LocalDate exp_date) {
		// TODO Auto-generated method stub
		CustomerCcard customer = new CustomerCcard(name, street, city, state, email, zip);
		customer.addAccount(new Silver(cc_number, exp_date));
		return customer;
	}

	@Override
	public CustomerCcard createBronzeAccountt(String name, String street, String city, String state, int zip,
			String email, String cc_number, LocalDate exp_date) {
		// TODO Auto-generated method stub
		CustomerCcard customer = new CustomerCcard(name, street, city, state, email, zip);
		customer.addAccount(new Bronze(cc_number, exp_date));
		return customer;
	}

	

}
