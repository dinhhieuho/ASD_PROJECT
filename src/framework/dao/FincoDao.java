package framework.dao;

import java.util.List;
import java.util.Optional;

import framework.fincoCustomer.Customer;
import framework.fincoCustomer.FincoCustomer;


/**
 * 
 * @author SARFO PHILIP
 *
 */
public interface FincoDao {
	/**
	 * @param Adds Customer to collection
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * <p>Finds all Customers available</p>
	 */
	public List<Customer> findAll();
	
	/**
	 * Removes a customer from the collection
	 * @param customer
	 */
	public void delete(Customer customer);
	
	
	/**
	 * <p>Searches in the db customer with {@code name}
	 * @param name
	 * @return
	 */
	public Optional<Customer> findCustomerByName(String name);
}
