package banking;

public class CheckingAccount extends BankAccount {
	
	private double balance ;
	private String acctype = "Checking";
	
	public CheckingAccount(String accNumber) {
		super(accNumber);
		this.balance = 0.0;
	}


	private final double interestRate = 0.01;

	@Override
	public void addInterest() {
		balance = balance + computeInterest();
	}
	
	private double computeInterest() {
		return balance * interestRate;
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
