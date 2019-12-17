package banking;


import framework.Finco;
import framework.ui.FincoView;

public class Bank extends Finco{
	public static void main(String[] args) {
		(new Bank()).run();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		setView(new BankView());
		super.run();
	}
	
	@Override
	public void setView(FincoView view) {
		// TODO Auto-generated method stub
		super.setView(view);
	}
}
