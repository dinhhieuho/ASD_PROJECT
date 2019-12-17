package framework.dao;

import java.util.List;
import java.util.Optional;

import framework.db.FincoDb;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;

public class FincoDaoImpl implements FincoDao {

	private FincoDb<Customer> dbInstance = FincoDb.getInstance();

	@Override
	public void addCustomer(Customer customer) {
		dbInstance.add(customer);
		System.out.println("Db Status: Customer created "+customer);
	}

	@Override
	public List<Customer> findAll() {
		return dbInstance;
	}

	@Override
	public void delete(Customer customer) {
		dbInstance.remove(customer);
	}

	@Override
	public Optional<Customer> findCustomerByName(String name) {
		return dbInstance.stream().filter(c->c.getName().equals(name)).findAny();
	}

	@Override
	public Optional<Customer> findAccountByAccountNumber(String accountNumber) {
		return dbInstance.stream().filter(c->c.findAccount(accountNumber) != null).findAny();
	}

}
