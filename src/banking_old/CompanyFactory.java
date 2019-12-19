package banking_old;

import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;

public class CompanyFactory extends BankFactory{

	@Override
	public Account createCheckingAccount(String accNumber) {
		return new CheckingAccount(accNumber);
	}

	@Override
	public Account createSavingAccount(String accNumber) {
		return new CheckingAccount(accNumber);
	}
	
	public Customer createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, int numEmps) {
		Customer customer = new Company(name, street, city, state, zip, email, numEmps);
		if(accType.equalsIgnoreCase("checking"))
			return customer.addAccount(createCheckingAccount(accountNo));
		
		return customer.addAccount(createSavingAccount(accountNo));
	}


}
