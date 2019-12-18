package creditcard;

import java.util.HashMap;

import framework.fincoAccount.Account;

public interface DataAccess {
	public HashMap<String, CcardAccount> readAccountsMap();

	public void saveNewAccount(CcardAccount acc);
}
