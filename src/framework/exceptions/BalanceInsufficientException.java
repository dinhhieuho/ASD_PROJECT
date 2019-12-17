/**
 * 
 */
package framework.exceptions;

/**
 * @author SARFO PHILIP
 *
 */
public class BalanceInsufficientException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BalanceInsufficientException(String message) {
		System.out.println("Balance Insufficient");
	}

}
