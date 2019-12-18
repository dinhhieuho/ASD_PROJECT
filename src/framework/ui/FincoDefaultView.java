package framework.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.controller.ControllerContext;
import framework.controller.CustomerController;
import framework.controller.FincoController;
import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;

public class FincoDefaultView extends FincoView {

	List<JButton> topButtons = new ArrayList();
	List<JButton> rightButtons = new ArrayList();

	private FincoDefaultView view = this;
	protected ControllerContext context = new ControllerContext(this); // set context
	protected FincoDao fincoDao = new FincoDaoImpl(); // db access

	// default buttons
	JButton JButton_Exit = new JButton();
	JButton JButton_Customer = new JButton();
	JButton JButton_Credit = new JButton();

	JPanel JPanel1 = new JPanel();

	private JTable JTable1;
	private JScrollPane JScrollPane1;

	private String title;
	ActionListener AL;

	public FincoDefaultView() {
		buildDefaultView();
	}

	public FincoDefaultView(String title, ActionListener AL) {
		this.title = title;
		this.AL = AL;
		setFincoViewTitle("Finco Default View");
	}

	public void buildDefaultView() {

		context.populateAccounts();

		JButton_Customer.setText("Add Customer");
		JButton_Credit.setText("Credit Account");

		addTopButton(JButton_Customer);
		addTopButton(JButton_Credit);
		// addTopButton(JButton_Credit1);

		JButton JButton_Debit = new JButton();
		JButton_Debit.setText("Debit Account");

		addRightButton(JButton_Debit);

		buildGUI();

		/*
		 * SymAction lSymAction = new SymAction();
		 * JButton_Exit.addActionListener(lSymAction);
		 * JButton_PerAC.addActionListener(lSymAction);
		 * JButton_CompAC.addActionListener(lSymAction);
		 * JButton_Deposit.addActionListener(lSymAction);
		 * JButton_Withdraw.addActionListener(lSymAction);
		 * JButton_Addinterest.addActionListener(lSymAction);
		 */

		JButton_Customer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerBtn("defaultcustomer", new CustomerController());
				CustomerDialogBox pac = new CustomerDialogBox(view, context);
				pac.setBounds(450, 20, 300, 330);
				pac.show();

			}
		});

		JButton_Debit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DebitDialog debitDialog = new DebitDialog(view);
				debitDialog.setBounds(450, 20, 300, 330);
				debitDialog.show();
			}
		});

		JButton_Credit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreditDialog creditDialog = new CreditDialog(view);
				creditDialog.setBounds(450, 20, 300, 330);
				creditDialog.show();
			}
		});

	}

	public void addTopButton(JButton btn) {
		topButtons.add(btn);
	}

	public void addRightButton(JButton btn) {
		rightButtons.add(btn);
	}

	@Override
	public void setTableModel(DefaultTableModel model) {
		JTable1 = new JTable(model);
	}

	@Override
	public void updateTableModel(DefaultTableModel model) {
		JTable1.setModel(model);
	}

	public void buildGUI() {
		setTitle(title);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);

		JScrollPane1 = new JScrollPane();

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		// Add Top buttons
		int count = 0;
		for (JButton btn : topButtons) {
			JPanel1.add(btn);
			btn.setBounds(24 * (count * 10), 20, 192, 33);
			count++;
		}

		// add right buttons
		count = 0;
		for (JButton btn : rightButtons) {
			JPanel1.add(btn);
			btn.setBounds(468, 104 + (count * 60), 96, 33);
			count++;
		}

		// Add Exit button
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);

		JButton_Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == FincoDefaultView.this)
				MainViewFW_windowClosing(event);
		}
	}

	void MainViewFW_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		MainViewFW_windowClosing_Interaction1(event);
	}

	void MainViewFW_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		this.setVisible(true);
	}

	@Override
	public void setFincoViewTitle(String title) {
		this.title = title;
	}

	public void registerBtn(JButton btn, String actionCommand, FincoController fc) {
		btn.setActionCommand(actionCommand);
		context.registerPerformer(fc, actionCommand);
	}

	public void registerBtn(String actionCommand, FincoController fc) {
		context.registerPerformer(fc, actionCommand);
	}

	public void actionHandler(ActionEvent e) {
		context.actionEventHandler(e, null);

	}

	public ControllerContext getContext() {
		return this.context;

	}

	public String retRieveAccNr(DefaultTableModel model) {
		String accnr = null;
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String) model.getValueAt(selection, 0);
		}
		return accnr;
	}

}
