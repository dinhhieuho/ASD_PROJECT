package framework.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import framework.ui.FincoView;

public class ControllerContext {
	FincoController controller = new CustomerController();
	FincoController debController = new DebitController();
	FincoController credController = new CreditController();
	
	private FincoView context;
	
	public ControllerContext(FincoView context) {
		this.context = context;
	}
	
	public void addCustomer(String name, String street, String city, String state, String zip, String email,String accountNumber) {
		

		if(!name.isEmpty() && !street.isEmpty() &&
				!city.isEmpty() && !state.isEmpty() && !zip.isEmpty() 
				&& !email.isEmpty() && !accountNumber.isEmpty()) {

			Map<String, String> arg = new HashMap<String, String>();
			
			arg.put("name",name);
			arg.put("street",street);
			arg.put("city",city);
			arg.put("state",state);
			arg.put("zip", zip);
			arg.put("email", email);
			arg.put("accountNumber",accountNumber);
			
			controller.actionHandler(arg,context);
			
		}else {
			JOptionPane.showMessageDialog(context, "All fields are required");
		}
		
		
	}
	
	public void debitAccount(String accNumber, double amount) {
		Map<String, String> arg = new HashMap<String, String>();
		
	
		arg.put("accNumber",String.valueOf(accNumber));
		arg.put("amount",String.valueOf(amount));
		
		debController.actionHandler(arg,context);
	}
	
	public void creditAccount(String customerName, int accNumber, double amount) {
		
		Map<String, String> arg = new HashMap<String, String>();
		
		arg.put("name",customerName);
		arg.put("number",String.valueOf(accNumber));
		arg.put("amount",String.valueOf(amount));
		
		credController.actionHandler(arg,context);
	}
}
