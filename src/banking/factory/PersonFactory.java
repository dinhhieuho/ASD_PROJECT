package banking.factory;

import banking.account.CheckingAccount;
import banking.account.SavingAccount;
import banking.customer.Person;
import framework.account.AccountDefault;
import framework.customer.Customer;
import framework.customer.CustomerDefault;

public class PersonFactory extends BankFactory{

	@Override
	public AccountDefault createCheckingAccount(String accNumber) {
		
		return new CheckingAccount(accNumber);
	}

	@Override
	public AccountDefault createSavingAccount(String accNumber) {	
		return new SavingAccount(accNumber);
	}
	
	public CustomerDefault createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, String dob) {
		Customer customer = new Person(name, street, city, state, zip, email, dob);
		if(accType.equalsIgnoreCase("checking"))
			return customer.addAccount(createCheckingAccount(accountNo));
		
		return customer.addAccount(createSavingAccount(accountNo));
	}

}
