package banking.account;

public class SavingAccount extends BankAccount{
	private double balance;
	private String acctype = "Savings";
	
	public SavingAccount(String accNumber) {
		super(accNumber);
	}

	private final double interestRate = 0.0325;

	@Override
	public void addInterest() {
		balance = balance + computeInterest();
		System.out.println(balance);
	}
	
	private double computeInterest() {
		return balance * interestRate;
	}
	public double getbalance() {
		return balance;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getAccountType() {

		return acctype;
	}
	
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
