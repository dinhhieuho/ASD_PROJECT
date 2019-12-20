package banking.account;

import framework.account.Account;
import framework.account.AccountDefault;

public  abstract class BankAccount extends  AccountDefault{
	public BankAccount(String accNumber) {
		super(accNumber);
	}

	public abstract void addInterest();
	public abstract String  getAccountType();
}
