package creditcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import framework.controller.FincoController;
import framework.fincoAccount.FincoAccount;
import framework.ui.FincoView;

public  class CcardController implements FincoController{

	List<FincoAccount> accounts = new ArrayList();
	public void actionHandler(Map<String, String> arg, FincoView view) {
		
	}
	
	public void addAccount(FincoAccount acc) {
		accounts.add(acc);
	}
	public List<FincoAccount> getAccounts() {
		return accounts;
	}

}
