package framework.controller;

import java.util.Map;
import java.util.Optional;

import javax.swing.JOptionPane;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.fincoCustomer.Customer;
import framework.fincoFactory.CustomerFactory;
import framework.fincoFactory.FincoFactory;
import framework.fincoFactory.TableEventFactory;
import framework.ui.FincoView;

public class CustomerController implements FincoController {

	private FincoFactory fincoFactory = new CustomerFactory();
	private FincoDao fincoDao = new FincoDaoImpl();

	public void actionHandler(Map<String, String> arg, FincoView view) {
		try {
			Optional<Customer> customer = fincoDao.findAccountByAccountNumber(arg.get("accountNumber"));
			if (!customer.isPresent()) {
				Customer cust = fincoFactory.createCustomer(arg.get("name"), arg.get("street"), arg.get("city"), arg.get("state"),
						Integer.parseInt(arg.get("zip")), arg.get("email"), arg.get("accountNumber"));
				
				//Save in dao
				fincoDao.addCustomer(cust);
				
				JOptionPane.showMessageDialog(view, "Account Created");
				
				//Update table view
				TableEventFactory.notifyTableListeners(view);
				
			} else {
				JOptionPane.showMessageDialog(view, "Account Exists Already");
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "Invalid number format");
		}

	}

}
