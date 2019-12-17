package banking;

import framework.fincoAccount.FincoAccount;

public class PersonFactory extends BankFactory{

	@Override
	public FincoAccount createCheckingAccount(String number) {
		// TODO Auto-generated method stub
		return new CheckingAccount(number);
	}

	@Override
	public FincoAccount createSavingAccount(String number) {
		// TODO Auto-generated method stub
		return new SavingAccount(number);
	}


}
