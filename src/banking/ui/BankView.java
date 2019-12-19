package banking.ui;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import framework.account.Account;
import framework.customer.Customer;
import framework.ui.FincoDefaultView;

public class BankView extends FincoDefaultView {

	DefaultTableModel model;

	// bank buttons
	JButton addPersonal = new JButton("Add Personal Account");
	JButton addCompany = new JButton("Add Company Account");
	JButton addInterest = new JButton("Add Interest");
	JButton deposit = new JButton("Deposit");
	JButton withdraw = new JButton("Withdraw");

	public BankView() {
		setTitle("Bank Application");

		// set button bounds
		addPersonal.setBounds(240, 20, 192, 33);
		addInterest.setBounds(448, 20, 106, 33);

		addTopButton(addPersonal);
		addTopButton(addCompany);
		addTopButton(addInterest);
		
		addRightButton(deposit);
		addRightButton(withdraw);
		
		buildGUI();

		// add actionListeners
		addInterest.addActionListener(e -> {
		//	actionHandler(e);
			refreshTable();
		});
		addCompany.addActionListener(e -> {
			//JDialog_AddCompAcc pac = new JDialog_AddCompAcc(this, context);
//				pac.setBounds(450, 20, 300, 330);
//				pac.show();
				//
				refreshTable();
		});
		
		addPersonal.addActionListener(e -> {
//			JDialog_AddPAcc pac = new JDialog_AddPAcc(this, context);
//				pac.setBounds(450, 20, 300, 330);
//				pac.show();
//				//
//				refreshTable();
		});
		
		deposit.addActionListener(e -> {
			String accnr = retRieveAccNr(model);
			if(accnr != null) {
//			JDialog_Deposit pac = new JDialog_Deposit(this, context,accnr);
//				pac.setBounds(450, 20, 300, 330);
//				pac.show();
//				//
//				refreshTable();
			}
		});
		
		withdraw.addActionListener(e -> {
			String accnr = retRieveAccNr(model);
			if(accnr != null) {
//			JDialog_Withdraw pac = new JDialog_Withdraw(this, context,accnr);
//				pac.setBounds(450, 20, 300, 330);
//				pac.show();
//				//
//				refreshTable();
			}
		});
		
		
		// register buttons
//		registerBtn(addInterest, "bankinterest", new InterestController());
//		registerBtn(addCompany, "companyaccount", new CompanyAccController());
//		registerBtn(addPersonal, "personaccount", new PersonAccController());
//		registerBtn(deposit, "deposit", new CreditController());
//		registerBtn(withdraw, "debit", new DebitController());

	}

	public void refreshTable() {
		Object[] rowdata = new Object[8];
		
		model = new DefaultTableModel();
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
//		for (Customer customer : fincoDao.findAll()) {
//			Account account = customer.getAccounts().entrySet().iterator().next().getValue();
//
//			rowdata[0] = account.getAccountNumber();
//			rowdata[1] = customer.getName();
//			rowdata[2] = customer.getCity();
//			rowdata[3] = customer.getCustomerType(); // ctype
//			rowdata[4] = account.getAccountType(); // atype
//			rowdata[5] = account.getBalance() + "";
//			model.addRow(rowdata);
//		}

		// update table
		updateTableModel(model);
	}

	@Override
	public void buildDefaultView() {
		// table columns
		model = new DefaultTableModel();
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");

		setTableModel(model);
		// ControllerContext context = new ControllerContext(this);
		// super.context.populateAccounts();
	}
}
