package framework;

import java.util.Map;

public class DebitController extends FincoController {

	@Override
	public void actionHandler(Map<String, String> arg) {
		// TODO Auto-generated method stub
		//arg.put("name",customerName);
		//arg.put("number",String.valueOf(accNumber));
		//arg.put("amount",String.valueOf(amount));
		
		FincoCustomer cus = findCustomerByName(arg.get("name"));
		cus.debit(arg.get("accNumber"), arg.get("amount"));
	}

}
