package creditcard.factory;


import java.time.LocalDate;

import creditcard.account.Gold;
import creditcard.account.Silver;
import framework.account.Account;

public class CcardServiceFactory extends CcardFactory{

	@Override
	public Account createGoldAccount(String accountNo,LocalDate expiryDate) {
		return new Gold(accountNo,expiryDate);
	}

	@Override
	public Account createSilverAccount(String accountNo,LocalDate expiryDate) {
		return new Silver(accountNo,expiryDate);
	}

	@Override
	public Account createBronzeAccount(String accountNo,LocalDate expiryDate) {
		return new Silver(accountNo,expiryDate);
	}

	

	

}
