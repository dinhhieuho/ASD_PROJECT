package banking;

import banking.ui.BankView;
import framework.Finco;
import framework.ui.FincoView;

public class Bank extends Finco{
	
	private FincoView view = new BankView();
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.view.run();
	}
	
	@Override
	public void setView(FincoView view) {
		super.setView(view);
	}

}
