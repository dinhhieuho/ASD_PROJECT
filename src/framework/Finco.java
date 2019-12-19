package framework;

import framework.controller.Controller;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.ui.DefaultView;
import framework.ui.FincoView;

public class Finco {

	private static DataAccess dao = new DataAccessService();
	private static Controller controller = new Controller(dao);
	private static FincoView view = new DefaultView(controller);
	
	public static void main(String[] args) {
		view.run();
	}
	
	public void setView(FincoView view) {
		Finco.view = view;
	}
	
	public static FincoView getView() {
		return view;
	}
}
