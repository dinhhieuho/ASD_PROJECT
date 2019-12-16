package banking;

import framework.FincoAccount;

public class PersonFactory extends BankFactory{

	@Override
	public FincoAccount createCheckingAccount() {
		// TODO Auto-generated method stub
		return new CheckingAccount();
	}

	@Override
	public FincoAccount createSavingAccount() {
		// TODO Auto-generated method stub
		return new SavingAccount();
	}

}
