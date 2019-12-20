package creditcard.factory;

import java.time.LocalDate;

import framework.account.Account;
import framework.factory.CustomerFactory;

public abstract class CcardFactory extends CustomerFactory {
	public abstract Account createGoldAccount(String accountNo,LocalDate expiryDate);
	public abstract Account createSilverAccount(String accountNo,LocalDate expiryDate);
	public abstract Account createBronzeAccount(String accountNo,LocalDate expiryDate);
	

}
