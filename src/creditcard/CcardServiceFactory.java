package creditcard;

import framework.FincoAccount;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public FincoAccount createGoldAccount() {
		
		return new Gold();
	}

	@Override
	public FincoAccount createSilverAccountt() {
		// TODO Auto-generated method stub
		return new Silver();
	}

	@Override
	public FincoAccount createBronzeAccountt() {
		// TODO Auto-generated method stub
		return new Bronze();
	}

	

}
