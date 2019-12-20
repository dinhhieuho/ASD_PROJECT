package creditcard.factory;


import java.time.LocalDate;

import creditcard.account.CcardAccount;
import creditcard.account.Gold;
import creditcard.account.Silver;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public CcardAccount createGoldAccount(String accountNo) {
		return new Gold(accountNo,LocalDate.now().plusDays(8),"Gold");
	}

	@Override
	public CcardAccount createSilverAccount(String accountNo) {
		return new Silver(accountNo,LocalDate.now().plusDays(8),"Silver");
	}

	@Override
	public CcardAccount createBronzeAccount(String accountNo) {
		return new Silver(accountNo,LocalDate.now().plusDays(8),"Bronze");
	}

	

	

}
