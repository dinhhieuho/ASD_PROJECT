package framework;

import framework.ui.FincoDefaultView;
import framework.ui.FincoView;
import framework.ui.MainViewFW;

public class Finco {

	FincoView view = new FincoDefaultView();
	FincoView mainView = new MainViewFW();
	
	public static void main(String[] args) {
		(new Finco()).run();
	}
	public void run() {
		mainView.run();
	}
	public void setView(FincoView view) {
		this.view = view;
	}
}
