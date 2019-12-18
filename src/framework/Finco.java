package framework;

import framework.ui.FincoDefaultView;
import framework.ui.FincoView;

public class Finco {

	static FincoView view = new FincoDefaultView();
	
	public static void main(String[] args) {
		(new Finco()).view.run();
	}
	
	public void setView(FincoView view) {
		Finco.view = view;
	}
	
	public static FincoView getView() {
		return view;
	}
}
