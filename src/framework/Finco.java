package framework;

import framework.controller.Controller;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.ui.DefaultGUI;
import framework.ui.GUI;

public class Finco {

	protected static DataAccess dao = new DataAccessService();
	protected static Controller controller = new Controller(dao);
	protected static GUI view = new DefaultGUI(controller);
	
	public static void main(String[] args) {
		view.run();
	}
	
	public void setView(GUI view) {
		Finco.view = view;
	}
	
	public static GUI getView() {
		return view;
	}
}
