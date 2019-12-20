package framework.exceptions;

public class AccountNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountNotFoundException(String message) {
		System.out.println("Account Not found");
	}

}
