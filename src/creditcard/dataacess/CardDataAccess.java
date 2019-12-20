
package creditcard.dataacess;

import java.util.List;
import java.util.Optional;

import creditcard.customer.CustomerCcard;
import framework.db.Database;

public class CardDataAccess{
	
	public Database<CustomerCcard> dbInstance = Database.getInstance();
	
	public  List<CustomerCcard> loadCustomers() {
		return dbInstance;
	}
	
	public  void saveCustomer(CustomerCcard customerCcard) {
		dbInstance.add(customerCcard);
	}
	
	
	public Optional<CustomerCcard> findAccountByAccountNumber(String ccNumber) {
		return dbInstance.stream().filter(c -> c.findAccount(ccNumber) != null).findAny();
	}
	
	
	
	
}

