package banking;

import framework.fincoAccount.Account;

public  abstract class BankAccount extends  Account{
	public BankAccount(int accNumber) {
		super(accNumber);
		// TODO Auto-generated constructor stub
	}

	public abstract void addInterest();
}
