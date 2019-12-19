package framework.fincoobservable;

import javax.swing.table.DefaultTableModel;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.ui.FincoView;

public class FincoTableObserver implements FincoObserver {

	private FincoSubject<FincoObserver> subject;

	DataAccess fincoDao = new DataAccessService();

	public FincoTableObserver(FincoSubject<FincoObserver> subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		FincoView view = subject.getState();

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
