package banking;

public class CheckingAccount extends BankAccount {
	
	private double balance ;
	
	public CheckingAccount(String accNumber) {
		super(accNumber);
	}


	private final double interestRate = 0.01;

	@Override
	public void addInterest() {
		balance = balance + computeInterest();
	}
	
	private double computeInterest() {
		return balance * interestRate;
	}
	
	public double getbalance() {
		return balance;
	}

}
