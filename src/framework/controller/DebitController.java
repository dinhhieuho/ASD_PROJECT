package framework.controller;

import java.util.Map;
import java.util.Optional;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.fincoCustomer.Customer;

public class DebitController implements FincoController {
	
	private FincoDao fincoDao = new FincoDaoImpl();

	@Override
	public void actionHandler(Map<String, String> arg) {	
		Optional<Customer> customer = fincoDao.findCustomerByName(arg.get("name"));
		customer.ifPresent(a->{
			try {
				a.debit(arg.get("accNumber"), Double.parseDouble(arg.get("amount")));
			} catch (NumberFormatException | AccountNotFoundException | BalanceInsufficientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}
