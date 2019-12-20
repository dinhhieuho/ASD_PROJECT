package banking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;

public class Controller extends framework.controller.Controller {
	private DataAccess dataAccess;

	public Controller(DataAccess dataAccess2) {
		super(dataAccess2);
		this.dataAccess = dataAccess2;
	}

	public void addInterest() {
		List<CustomerDefault> cs = dataAccess.findAll();
		for (CustomerDefault c : cs) {
			HashMap<String, AccountDefault> ac = c.getAccounts();
			Set<String> keys = ac.keySet();
			keys.forEach(key -> {
				ac.get(key).addInterest();
			});
			
		}
		
		cs.get(0).getSubject().setState();
	}

}
