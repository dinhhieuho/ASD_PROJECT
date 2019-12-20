package framework.dao;

import java.util.List;
import java.util.Optional;

import framework.customer.CustomerDefault;
import framework.db.Database;

public class DataAccessService implements DataAccess {

	public Database<CustomerDefault> dbInstance = Database.getInstance();

	@Override
	public void addCustomer(CustomerDefault customer) {
		dbInstance.add(customer);
		System.out.println("Db Status: Customer created " + dbInstance);
	}

	@Override
	public List<CustomerDefault> findAll() {
		return dbInstance;
	}

	@Override
	public void delete(CustomerDefault customer) {
		dbInstance.remove(customer);
	}

	@Override
	public Optional<CustomerDefault> findCustomerByName(String name) {
		return dbInstance.stream().filter(c -> c.getName().equals(name)).findAny();
	}

	@Override
	public Optional<CustomerDefault> findAccountByAccountNumber(String accountNumber) {
		return dbInstance.stream().filter(c -> c.findAccount(accountNumber) != null).findAny();
	}

	private void print() {
		dbInstance.stream().forEach(System.out::println);
	}

}
