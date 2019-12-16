package framework;




public abstract class CcardFactory extends CustomerFactory {
	public abstract FincoAccount createGoldAccount();
	public abstract FincoAccount createSilverAccountt();
	public abstract FincoAccount createBronzeAccountt();

}
