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

import framework.controller.Controller;
import framework.factory.CustomerFactory;
import framework.observable.JtableViewObservable;
import framework.observable.Observable;

public class DefaultGUI extends GUI {

	// list of buttons for customization
		private List<JButton> topButtons = new ArrayList();
		private List<JButton> rightButtons = new ArrayList();

		// default buttons
		JButton JButton_Exit = new JButton("Exit");
		JButton JButton_Customer = new JButton("Add Customer");
		JButton JButton_Credit = new JButton("Credit Account");
		JButton JButton_Debit = new JButton("Debit Account");

		// view panel
		JPanel JPanel1 = new JPanel();

		// table for listing customers
		private TableView customerList;
		private Object[] defaultColumns = { "AccountNr", "Name", "City", "Amount" }; // default columns

		// Scroll pane
		private JScrollPane JScrollPane1;

		// Frame title
		private String title = "Finco FrameWork";

		// controller for business logic
		private Controller controller;

		// factory for creating new customers
		protected CustomerFactory customerFactory;
		
		private JtableViewObservable<TableView> subject;

		public DefaultGUI(Controller controller) {
			this.controller = controller;
			customerFactory = new CustomerFactory(); // default factory
		}
		
		public DefaultGUI(Controller controller, JtableViewObservable<TableView> subject) {
			this.controller = controller;
			customerFactory = new CustomerFactory(); // default factory
			this.subject = subject;
		}

		{
			// default Top buttons;
			addTopButton(JButton_Customer);
			addTopButton(JButton_Credit);

			// default Right buttons;
			addRightButton(JButton_Debit);
		}
		// set actionlisteners for default buttons
		{
			JButton_Customer.addActionListener(e -> {
				CustomerDialogBox pac = new CustomerDialogBox(customerFactory, controller, subject);
				pac.setBounds(450, 20, 300, 330);
				pac.show();
			});

			JButton_Debit.addActionListener(e -> {
				String accnr = retRieveAccNr(customerList.getTvModel());
				if (accnr != null) {
					DebitDialog pac = new DebitDialog(controller,accnr);
					pac.setBounds(450, 20, 300, 330);
					pac.show();
				}
			});

			JButton_Credit.addActionListener(e -> {
				String accnr = retRieveAccNr(customerList.getTvModel());
				if (accnr != null) {
					CreditDialog pac = new CreditDialog(controller, accnr);
					pac.setBounds(450, 20, 300, 330);
					pac.show();
				}
			});

		}

		public void addTopButton(JButton btn) {
			topButtons.add(btn);
		}

		public void addRightButton(JButton btn) {
			rightButtons.add(btn);
		}

		@Override // not necessary
		public void setTableModel(DefaultTableModel model) {
			customerList.setModel(model);
		}

		@Override // not necessary
		public void updateTableModel(DefaultTableModel model) {
			customerList.setModel(model);
		}

		public void buildGUI() {
			setTitle(title);
			setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout(0, 0));
			setSize(975, 410);
			setVisible(false);
			JPanel1.setLayout(null);
			getContentPane().add(BorderLayout.CENTER, JPanel1);
			JPanel1.setBounds(0, 0, 975, 310);

			JScrollPane1 = new JScrollPane();
			if(subject != null) {
				customerList = new TableView(defaultColumns, subject);
			}
			else
				customerList = new TableView(defaultColumns);
			JPanel1.add(JScrollPane1);
			JScrollPane1.setBounds(12, 92, 444, 160);
			JScrollPane1.getViewport().add(customerList);
			customerList.setBounds(0, 0, 420, 0);

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
				btn.setBounds(468, 104 + (count * 50), 96, 33);
				count++;
			}

			// Add Exit button
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
				if (object == DefaultGUI.this)
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
			buildGUI();
			this.setVisible(true);
		}

		@Override
		public void setFincoViewTitle(String title) {
			this.title = title;
		}

		public void setTableColumns(Object[] tableColumns) {
			this.defaultColumns = tableColumns;
		}

		public void setFactory(CustomerFactory customerFactory) {
			this.customerFactory = customerFactory;
		}

		public String retRieveAccNr(DefaultTableModel model) {
			String accnr = null;
			int selection = customerList.getSelectionModel().getMinSelectionIndex();
			if (selection >= 0) {
				accnr = (String) model.getValueAt(selection, 0);
			}
			return accnr;
		}
		
		public void resetDefaultButtons() {
			topButtons.clear();
			rightButtons.clear();
		}
		
		public Controller getController() {
			return this.controller;
		}
		
		public DefaultTableModel getDefautModel() {
			return customerList.getTvModel();
		}
		
		public CustomerFactory getFactory() {
			return this.customerFactory;
		}
		
		public JtableViewObservable<TableView> getSubject(){
			return this.subject;
		}
}
