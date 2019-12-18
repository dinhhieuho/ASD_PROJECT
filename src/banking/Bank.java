package banking;

import framework.Finco;
import framework.ui.FincoView;

public class Bank extends Finco{
	
	private FincoView view = super.getView();
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setView(new BankView());
		bank.view.setTitle("Banking Application");
		bank.view.run();
	}
	
	@Override
	public void setView(FincoView view) {
		super.setView(view);
	}

}
