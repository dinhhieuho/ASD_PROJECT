package banking;

import banking.ui.BankGUI;
import framework.Finco;
import framework.ui.DefaultGUI;

public class Bank extends Finco{
	
	private BankGUI gui = new BankGUI();
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.gui.run();
	}
	
	@Override
	public void setView(DefaultGUI view) {
		super.setView(view);
	}

}
