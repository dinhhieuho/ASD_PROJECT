package banking;

import framework.fincoAccount.Account;

public abstract class BankAccount extends Account {
	public BankAccount(String accountNumber) {
		super(accountNumber);
		// TODO Auto-generated constructor stub
	}

	public abstract void addInterest();
}
