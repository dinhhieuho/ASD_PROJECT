package framework.doa;

import java.util.List;

import framework.db.FincoDb;
import framework.fincoCustomer.Customer;

public class FincoDoaImpl implements FincoDao {

	private FincoDb<Customer> dbInstance = FincoDb.getInstance();

	@Override
	public void addCustomer(Customer customer) {
		dbInstance.add(customer);
	}

	@Override
	public List<Customer> findAll() {
		return dbInstance;
	}

	@Override
	public void delete(Customer customer) {
		dbInstance.remove(customer);
	}

}
