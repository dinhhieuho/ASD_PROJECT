package banking_old;

public class SavingAccount extends BankAccount{
	private double balance;
	
	public SavingAccount(String accNumber) {
		super(accNumber);
	}

	private final double interestRate = 0.0325;

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
