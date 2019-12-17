package framework.fincoCustomer;

import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.fincoAccount.Account;

/**
 * 
 * @author SARFO PHILIP
 * Finco Customer Interface for customer
 *
 */

public interface FincoCustomer {
	
	/**
	 * 
	 * @param account {@code account is added to a customer account}
	 * supports chaining
	 */
	public Customer addAccount(Account account);
	
	
	/**
	 * 
	 * @param account the {@code account is used to remove an account from
	 * a customer account}
	 */
	public void removeAccount(Account account);
	
	
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
	
}
