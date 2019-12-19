package framework.observable;

import javax.swing.table.DefaultTableModel;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.ui.GUI;

public class JtableListener implements Listener {

	private Subject<Listener> subject;

	DataAccess fincoDao = new DataAccessService();

	public JtableListener(Subject<Listener> subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		GUI view = subject.getState();
		DefaultTableModel model = new DefaultTableModel();
		String[] rowdata = new String[4];
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("Amount");

		for (CustomerDefault customer : fincoDao.findAll()) {
			AccountDefault account = customer.getAccounts().entrySet().iterator().next().getValue();
			rowdata[0] = account.getAccountNumber();
			rowdata[1] = customer.getName();
			rowdata[2] = customer.getCity();
			rowdata[3] = String.valueOf(account.getBalance());
			model.addRow(rowdata);
		}
		view.updateTableModel(model);
		System.out.println("Finco [INFO]: Table event triggered!!");
	}

}
