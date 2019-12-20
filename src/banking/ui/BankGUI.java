package banking.ui;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import banking.factory.BankFactory;
import banking.factory.CompanyFactory;
import banking.factory.PersonFactory;
import framework.Finco;
import framework.controller.Controller;
import framework.factory.CustomerFactory;
import framework.ui.DefaultGUI;
import framework.ui.GUI;

public class BankGUI extends GUI {

	DefaultTableModel model;
	DefaultGUI gui = new Finco().getView();
	
	// bank buttons
	JButton addPersonal = new JButton("Add Personal Account");
	JButton addCompany = new JButton("Add Company Account");
	JButton addInterest = new JButton("Add Interest");
	JButton deposit = new JButton("Deposit");
	JButton withdraw = new JButton("Withdraw");
	JButton report = new JButton("Report");
	
	// controller for business logic
	private banking.controller.Controller controller;
	
	
	public BankGUI() {
		controller = new banking.controller.Controller(new Finco().getDefaultDBAccess());
		//
		gui.setFincoViewTitle("Bank Application");
		//setTitle("Bank Application");
		
		//reset buttons
		gui.resetDefaultButtons();

		// set button bounds
		addPersonal.setBounds(240, 20, 192, 33);
		addInterest.setBounds(448, 20, 106, 33);
		
		gui.addTopButton(addPersonal);
		gui.addTopButton(addCompany);
		gui.addTopButton(addInterest);
		gui.addTopButton(report);

		gui.addRightButton(deposit);
		gui.addRightButton(withdraw);
		
		//buildGUI();

		// add actionListeners
		addInterest.addActionListener(e -> {
			controller.addInterest();
		});
		addCompany.addActionListener(e -> {
			JDialog_AddCompAcc pac = new JDialog_AddCompAcc(new CompanyFactory(), controller, gui.getSubject());
				pac.setBounds(450, 20, 300, 330);
				pac.show();
		});
		
		addPersonal.addActionListener(e -> {
			JDialog_AddPAcc pac = new JDialog_AddPAcc(new PersonFactory(),controller, gui.getSubject());
				pac.setBounds(450, 20, 300, 330);
				pac.show();
				//
		});
		
		deposit.addActionListener(e -> {
			String accnr = gui.retRieveAccNr(gui.getDefautModel());
			if(accnr != null) {
			JDialog_Deposit pac = new JDialog_Deposit(this,accnr,controller);
				pac.setBounds(450, 20, 300, 330);
				pac.show();
				//
			}
		});
		
		withdraw.addActionListener(e -> {
			String accnr = gui.retRieveAccNr(gui.getDefautModel());
			if(accnr != null) {
			JDialog_Withdraw pac = new JDialog_Withdraw(this,accnr,controller);
				pac.setBounds(450, 20, 300, 330);
				pac.show();
//				//
//				refreshTable();
			}
		});
		
		report.addActionListener(e->{
			gui.getController().generateReport();
		});

	}


	@Override
	public void run() {
		gui.run();
		
	}


	@Override
	public void setTableModel(DefaultTableModel model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateTableModel(DefaultTableModel model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addTopButton(JButton button) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addRightButton(JButton button) {
		// TODO Auto-generated method stub
		
	}


}
