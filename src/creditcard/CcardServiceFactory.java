package creditcard;

import framework.FincoAccount;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public FincoAccount createGoldAccount() {
		
		return new Gold(0);
	}

	@Override
	public FincoAccount createSilverAccountt() {
		// TODO Auto-generated method stub
		return new Silver(0);
	}

	@Override
	public FincoAccount createBronzeAccountt() {
		// TODO Auto-generated method stub
		return new Bronze(0);
	}

	

}
