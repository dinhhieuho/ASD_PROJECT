package framework.fincoobservable;

import javax.swing.table.DefaultTableModel;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.fincoAccount.Account;
import framework.fincoCustomer.Customer;
import framework.ui.FincoView;

public class FincoTableObserver implements FincoObserver {

	private FincoSubject<FincoObserver> subject;

	FincoDao fincoDao = new FincoDaoImpl();

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

	
		for (Customer customer : fincoDao.findAll()) {
			Account account = customer.getAccounts().entrySet().iterator().next().getValue();
			rowdata[0] = account.getAccountNumber();
			rowdata[1] = customer.getName();
			rowdata[2] = customer.getCity();
			rowdata[3] = account.getAccountNumber();
			model.addRow(rowdata);
		}
		view.updateTableModel(model);
		System.out.println("Finco [INFO]: Table event triggered!!");
	}

}
