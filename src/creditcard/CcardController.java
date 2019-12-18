package creditcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.controller.FincoController;
import framework.fincoAccount.Account;
import framework.fincoAccount.FincoAccount;
import framework.ui.FincoView;

public  class CcardController implements FincoController{

	Map<String,CcardAccount> accounts = new HashMap<String,CcardAccount>();
	public void actionHandler(Map<String, String> arg, FincoView view) {
		
	}
	
	public void addAccount(String name,CcardAccount acc) {
		accounts.put(name,acc);
	}
	public Map<String,CcardAccount> getAccounts(){
		return accounts;
	}
	public CcardAccount getAccounts(String name) {
		return accounts.get(name);
	}
	
	public void deposit(String name, double amount) {
		double curramount = accounts.get(name).getBalance();
		accounts.get(name).setBalance(curramount+amount);
	}
	
	public void charge(String name, double amount) {
		double curramount = accounts.get(name).getBalance();
		accounts.get(name).setPrevious_balance(curramount);
		accounts.get(name).setBalance(curramount-amount);
		accounts.get(name).addCharge(amount);
	}

}
