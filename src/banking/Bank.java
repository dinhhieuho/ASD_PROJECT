package banking;

import banking.ui.BankGUI;
import framework.Finco;
import framework.ui.GUI;

public class Bank extends Finco{
	
	private GUI gui = new BankGUI(super.controller);
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.gui.run();
	}
	
	@Override
	public void setView(GUI view) {
		super.setView(view);
	}

}
