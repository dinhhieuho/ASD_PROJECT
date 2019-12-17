package framework.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerContext {
	FincoController controller = new CustomerController();
	FincoController debController = new DebitController();
	FincoController credController = new CreditController();
	
	public void addCustomer(String name, String street, String city, String state, int zip, String email) {
		
		Map<String, String> arg = new HashMap<String, String>();
		
		arg.put("name",name);
		arg.put("street",street);
		arg.put("city",city);
		arg.put("state",state);
		arg.put("zip", String.valueOf(zip));
		arg.put("email", email);
		
		controller.actionHandler(arg);
		
	}
	
	public void debitAccount(String customerName, int accNumber, double amount) {
		Map<String, String> arg = new HashMap<String, String>();
		
		arg.put("name",customerName);
		arg.put("number",String.valueOf(accNumber));
		arg.put("amount",String.valueOf(amount));
		
		debController.actionHandler(arg);
	}
	
	public void creditAccount(String customerName, int accNumber, double amount) {
		
		Map<String, String> arg = new HashMap<String, String>();
		
		arg.put("name",customerName);
		arg.put("number",String.valueOf(accNumber));
		arg.put("amount",String.valueOf(amount));
		
		credController.actionHandler(arg);
	}
}
