package framework.controller;

import java.util.Map;

import framework.fincoFactory.CustomerFactory;
import framework.fincoFactory.FincoFactory;

public class CustomerController implements FincoController {

	private FincoFactory fincoFactory = new CustomerFactory();

	public void actionHandler(Map<String, String> arg) {
		fincoFactory.createCustomer(arg.get("name"), arg.get("street"), arg.get("city"), arg.get("state"),
				Integer.parseInt(arg.get("zip")), arg.get("email"));

	}

}
