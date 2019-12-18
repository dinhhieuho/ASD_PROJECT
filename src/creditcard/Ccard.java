package creditcard;

import framework.Finco;
import framework.ui.FincoView;

public class Ccard extends  Finco{
	

	public static void main(String[] args) {
		(new CcardView()).run();
	}
	
	@Override
	public void setView(FincoView view) {
		// TODO Auto-generated method stub
		super.setView(view);
	}

	
}
