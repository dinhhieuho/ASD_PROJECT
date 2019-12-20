package creditcard.dataacess;

import java.util.List;

import creditcard.customer.CustomerCcard;
import framework.customer.CustomerDefault;
import framework.dao.DataAccessService;
import framework.db.Database;

public class CardDataAccess extends DataAccessService{
	
	public Database<CustomerCcard> dbInstance = Database.getInstance();


	
	
	public  List<CustomerCcard> loadCustomers() {
		return dbInstance;
	}
	
	public  void saveCustomer(CustomerCcard customerCcard) {
		System.out.println(dbInstance);
		dbInstance.add(customerCcard);
	}
	
	
	
}
