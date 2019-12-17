package framework.doa;

import java.util.List;

import framework.fincoCustomer.Customer;


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
}
