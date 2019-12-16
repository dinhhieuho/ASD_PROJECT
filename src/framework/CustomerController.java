package framework;

import java.util.Map;

public class CustomerController extends FincoController {
	
	CustomerController(){
		setFincoFactory(new CustomerFactory());
	}
	public void actionHandler(Map<String, String> arg) {
		// TODO Auto-generated method stub
		FincoCustomer cus = getFincoFactory().createCustomer(arg.get("name"), arg.get("street"), 
				arg.get("city"), arg.get("state"), Integer.parseInt(arg.get("zip")), arg.get("email"));
		
		cus.addAccount()
		
	}

}
