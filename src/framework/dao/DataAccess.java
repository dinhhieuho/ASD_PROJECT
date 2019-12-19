package framework.dao;

import java.util.List;
import java.util.Optional;

import framework.customer.Customer;
import framework.customer.CustomerDefault;


/**
 * 
 * @author SARFO PHILIP
 *
 */
public interface DataAccess {
	/**
	 * @param Adds Customer to collection
	 */
	public void addCustomer(CustomerDefault customer);
	
	/**
	 * <p>Finds all Customers available</p>
	 */
	public List<CustomerDefault> findAll();
	
	/**
	 * Removes a customer from the collection
	 * @param customer
	 */
	public void delete(CustomerDefault customer);
	
	
	/**
	 * <p>Searches in the db customer with {@code name}
	 * @param name
	 * @return
	 */
	public Optional<CustomerDefault> findCustomerByName(String name);
	
	
	/**
	 * Retrieves an account by an account number
	 * @param accountNumber
	 * @return
	 */
	public Optional<CustomerDefault> findAccountByAccountNumber(String accountNumber);
}
