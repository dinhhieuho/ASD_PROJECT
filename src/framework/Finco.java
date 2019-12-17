package framework;

import framework.ui.FincoView;
import framework.ui.MainViewFW;

public class Finco {

	//FincoView view = new FincoDefaultView();
	FincoView view;
	
	public static void main(String[] args) {
		(new Finco()).run();
	}
	public void run() {
		if(view==null)
			view = new MainViewFW();
		
		view.run();
	}
	public void setView(FincoView view) {
		this.view = view;
	}
}
