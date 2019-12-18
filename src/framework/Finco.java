package framework;

import framework.ui.FincoDefaultView;
import framework.ui.FincoView;

public class Finco {

	FincoView view = new FincoDefaultView();
	
	public static void main(String[] args) {
		(new Finco()).view.run();
	}
	
	public void setView(FincoView view) {
		this.view = view;
	}
	
	public FincoView getView() {
		return view;
	}
}
