package banking.factory;

import banking.account.CheckingAccount;
import banking.customer.Company;
import framework.account.AccountDefault;
import framework.customer.Customer;
import framework.customer.CustomerDefault;

public class CompanyFactory extends BankFactory{

	@Override
	public AccountDefault createCheckingAccount(String accNumber) {
		return new CheckingAccount(accNumber);
	}

	@Override
	public AccountDefault createSavingAccount(String accNumber) {
		return new CheckingAccount(accNumber);
	}
	
	public CustomerDefault createCustomer(String name, String street, String city, String state, int zip, String email, String accountNo, String accType, int numEmps) {
		CustomerDefault customer = new Company(name, street, city, state, zip, email, numEmps);
		System.out.println(accType);
		if(accType.equalsIgnoreCase("checking"))
			return customer.addAccount(createCheckingAccount(accountNo));
		
		return customer.addAccount(createSavingAccount(accountNo));
	}


}
