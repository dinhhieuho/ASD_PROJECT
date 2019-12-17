package framework.controller;

import java.util.Map;
import java.util.Optional;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.exceptions.AccountNotFoundException;
import framework.fincoCustomer.Customer;

public class CreditController implements FincoController {
	
	private FincoDao dao = new FincoDaoImpl();
	
	@Override
	public void actionHandler(Map<String, String> arg) {
		Optional<Customer> customer = dao.findCustomerByName(arg.get("name"));
		customer.ifPresent(c->{
			try {
				c.credit(arg.get("accNumber"), Double.parseDouble(arg.get("amount")));
			} catch (NumberFormatException | AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}
