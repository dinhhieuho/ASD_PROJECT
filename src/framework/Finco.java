package framework;

import framework.ui.FincoDefaultView;
import framework.ui.FincoView;

public class Finco {

	FincoView view = new FincoDefaultView();
	
	public static void main(String[] args) {
		(new Finco()).run();
	}
	public void run() {
		view.run();
	}
	public void setView(FincoView view) {
		this.view = view;
	}
}
