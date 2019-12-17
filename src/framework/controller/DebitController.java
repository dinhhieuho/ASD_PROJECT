package framework.controller;

import java.util.Map;
import java.util.Optional;

import javax.swing.JOptionPane;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.fincoCustomer.Customer;
import framework.ui.FincoView;

public class DebitController implements FincoController {

	private FincoDao fincoDao = new FincoDaoImpl();

	@Override
	public void actionHandler(Map<String, String> arg, FincoView view) {
		Optional<Customer> customer = fincoDao.findAccountByAccountNumber(arg.get("accNumber"));
		customer.ifPresent(a -> {
			try {
				a.debit(arg.get("accNumber"), Double.parseDouble(arg.get("amount")));
				JOptionPane.showMessageDialog(view, "Account Debited Successfully");
			} catch (NumberFormatException | AccountNotFoundException | BalanceInsufficientException e) {
				System.out.println("Error Occurred " + e.getLocalizedMessage());
				JOptionPane.showMessageDialog(view, "Insufficient Balance");
			}
		});
		if(!customer.isPresent()) {
			JOptionPane.showMessageDialog(view, "Account Not found");
		}
		
	}

}
