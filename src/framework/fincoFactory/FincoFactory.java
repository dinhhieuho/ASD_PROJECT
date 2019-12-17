package framework.fincoFactory;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.fincoEntry.Entry;

/**
 * 
 * @author SARFO PHILIP
 * Finco Factory for creation of buisines objects
 *
 */

public interface FincoFactory {
	
	/**
	 * <p>Creates a new customer and attaches a new account to the customer</p>
	 * @param name
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param email
	 * @return
	 */
	public Customer createCustomer(String name, String street, String city, String state, int zip, String email);
	
	/**
	 * <p>New Entry for account</p>
	 * @param amount
	 * @param date
	 * @return
	 */
	public Entry createEntry(double amount);
	
	
	/**
	 * <p>New Account for customer</p>
	 * create new account
	 * @return
	 */
	public Account createAccount();
}
