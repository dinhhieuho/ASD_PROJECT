package framework;



public abstract class BankFactory extends CustomerFactory {
	public abstract FincoAccount createCheckingAccount();
	public abstract FincoAccount createSavingAccount();

}
