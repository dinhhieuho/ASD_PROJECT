package framework;

import framework.controller.Controller;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.observable.JtableViewObservable;
import framework.ui.DefaultGUI;
import framework.ui.GUI;
import framework.ui.TableView;

public class Finco {

	protected static JtableViewObservable<TableView> subject = new JtableViewObservable<TableView>();
	private static DataAccess dao = new DataAccessService(subject);

	protected static Controller controller = new Controller(dao);
	protected static DefaultGUI view = new DefaultGUI(controller, subject);

	public static void main(String[] args) {
		view.run();
	}

	public void setView(DefaultGUI view) {
		Finco.view = view;
	}

	public DefaultGUI getView() {
		return view;
	}

	public DataAccess getDefaultDBAccess() {
		return this.dao;
	}
}
