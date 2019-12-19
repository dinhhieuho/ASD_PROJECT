package banking;

import framework.fincoAccount.Account;

public  abstract class BankAccount extends  Account{
	public BankAccount(String accNumber) {
		super(accNumber);
	}

	public abstract void addInterest();
	public abstract String  getAccountType();
}
