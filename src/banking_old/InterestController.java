package banking_old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.ui.FincoView;

public class InterestController extends BankController{
	
	FincoDao dao = new FincoDaoImpl();
	
	@Override
	public void actionHandler(Map<String, String> arg, FincoView view) {
		//dao.findAll().stream().map(customer -> customer.getAccounts()).map(acc -> acc.values()).forEach();
		List<Customer> cs = dao.findAll();
		for(Customer c : cs) {
			HashMap<String, Account> ac = c.getAccounts();
			Set<String> keys = ac.keySet();
			keys.forEach(key -> ac.get(key).addInterest());
		}
		
	}

//	public static void main(String [] args) {
//		(new InterestController()).actionHandler(null, null);
//	}
}
