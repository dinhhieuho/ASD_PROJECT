package creditcard;

import framework.fincoAccount.FincoAccount;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public FincoAccount createGoldAccount(String number) {
		// TODO Auto-generated method stub
		return new Gold(number);
	}

	@Override
	public FincoAccount createSilverAccount(String number) {
		// TODO Auto-generated method stub
		return new Silver(number);
	}

	@Override
	public FincoAccount createBronzeAccount(String number) {
		// TODO Auto-generated method stub
		return new Bronze(number);
	}

	

}
