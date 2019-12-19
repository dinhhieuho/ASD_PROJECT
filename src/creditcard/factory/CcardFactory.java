package creditcard.factory;

import java.time.LocalDate;
import java.util.List;

import creditcard.customer.CustomerCcard;
import framework.customer.Customer;
import framework.customer.CustomerDefault;


public abstract class CcardFactory{
	public abstract CustomerCcard createGoldAccount(String name, String street, String city, String state, int zip, String email, String cc_number, LocalDate exp_date);
	public abstract CustomerCcard createSilverAccountt(String name, String street, String city, String state, int zip, String email, String cc_number, LocalDate exp_date);
	public abstract CustomerCcard createBronzeAccountt(String name, String street, String city, String state, int zip, String email, String cc_number, LocalDate exp_date);
	
}
