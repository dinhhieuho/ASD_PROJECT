package banking;

import java.time.LocalDate;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoFactory.CustomerFactory;

public abstract class BankFactory extends CustomerFactory{
	public abstract Account createCheckingAccount(String accNumber);
	public abstract Account createSavingAccount(String accNumber);
	public  Customer createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, int numEmps) {
		return null;
	}
	public  Customer createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, String dob) {
		return null;
	}

}
