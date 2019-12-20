package framework.exceptions;

public class AccountExistException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountExistException(String message,Throwable t) {
		System.out.println("Account number exist already"+t.getMessage());
	}

}
