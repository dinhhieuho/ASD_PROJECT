package framework.customer;

import framework.account.Account;
import framework.account.AccountDefault;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

/**
 * 
 * @author SARFO PHILIP
 * Finco Customer Interface for customer
 *
 */

public interface Customer {
	
	/**
	 * 
	 * @param account {@code account is added to a customer account}
	 * supports chaining
	 */
	public CustomerDefault addAccount(AccountDefault account);
	
	
	/**
	 * 
	 * @param account the {@code account is used to remove an account from
	 * a customer account}
	 */
	public void removeAccount(AccountDefault account);
	
	
	/**
	 * @param message the {@code message to be sent}
	 */
	public void sendEmail(String message);
	
	
	/**
	 * <p>Method debits account</p>
	 * @param accountNumber
	 * @param amount
	 * @throws BalanceInsufficientException,AccountNotFoundException
	 * 
	 */
	public void debit(String accountNumber,double amount) throws BalanceInsufficientException,AccountNotFoundException;
	
	/**
	 * <p>Method credits account</p>
	 * @param accountNumber
	 * @param amount
	 * @throws AccountNotFoundException 
	 */
	public void credit(String accountNumber,double amount) throws AccountNotFoundException;
	
	public String getCustomerType();
	
}
