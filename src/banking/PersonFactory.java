package banking;

import java.time.LocalDate;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;

public class PersonFactory extends BankFactory{

	@Override
	public Account createCheckingAccount(String accNumber) {
		
		return new CheckingAccount(accNumber);
	}

	@Override
	public Account createSavingAccount(String accNumber) {
		
		return new SavingAccount(accNumber);
	}
	
	public Customer createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, LocalDate birthdate) {
		Customer customer = new Person(name, street, city, state, zip, email, birthdate);
		if(accType.equalsIgnoreCase("checking"))
			return customer.addAccount(createCheckingAccount(accountNo));
		
		return customer.addAccount(createSavingAccount(accountNo));
	}

}
