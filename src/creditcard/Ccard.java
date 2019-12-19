package creditcard;

import banking.Bank;
import creditcard.factory.CcardServiceFactory;
import creditcard.ui.CcardView;
import framework.Finco;
import framework.ui.FincoView;

public class Ccard /*extends  Finco*/{
	//private FincoView view = super.getView();
	

    static CcardServiceFactory factory = new CcardServiceFactory();
	
	public static void main(String[] args) {
		new CcardView(factory).run();
	}
	
	
	public void setView(FincoView view) {
		// TODO Auto-generated method stub
		//super.setView(view);
	}

}
