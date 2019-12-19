package framework.customer;

import framework.account.Account;
import framework.account.AccountDefault;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class PersonDefault extends  Person{
	
	private OrganizationDefault organization;
	
	
	public void setOrganization(OrganizationDefault organization) {
		this.organization = organization;
	}


	@Override
	public Customer addAccount(AccountDefault account) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removeAccount(AccountDefault account) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendEmail(String message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void debit(String accountNumber, double amount)
			throws BalanceInsufficientException, AccountNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return null;
	}



}
