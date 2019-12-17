package framework.controller;

import java.util.Map;
import java.util.Optional;

import javax.swing.JOptionPane;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.exceptions.AccountNotFoundException;
import framework.fincoCustomer.Customer;
import framework.ui.FincoView;

public class CreditController implements FincoController {
	
	private FincoDao dao = new FincoDaoImpl();
	
	@Override
	public void actionHandler(Map<String, String> arg,FincoView context) {
		Optional<Customer> customer = dao.findCustomerByName(arg.get("name"));
		customer.ifPresent(c->{
			try {
				c.credit(arg.get("accNumber"), Double.parseDouble(arg.get("amount")));
			} catch (NumberFormatException | AccountNotFoundException e) {
				JOptionPane.showMessageDialog(context, "An Exception Occured "+e.getMessage());
				System.out.println("Excetion occured "+e.getMessage());
				e.printStackTrace();
			}
		});
		
	}

}
