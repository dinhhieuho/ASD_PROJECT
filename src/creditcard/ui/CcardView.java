package creditcard.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import creditcard.factory.CcardServiceFactory;
import creditcard.account.CcardAccount;
import creditcard.controller.CcardController;
import creditcard.customer.CustomerCcard;
import framework.account.AccountDefault;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;
import framework.ui.CreditDialog;
import framework.ui.CustomerDialogBox;
import framework.ui.DebitDialog;
import framework.ui.FincoDefaultView;
import framework.ui.FincoView;

public class CcardView extends FincoView {
	/****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber, email;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CcardView thisframe;
    private Object rowdata[];
    
    CcardController controller = new CcardController();
    CcardServiceFactory factory;
    public CcardController getController() {
    	return controller;
    }
    
	public CcardView(CcardServiceFactory factory)
	{
		this.factory = factory;
		thisframe=this;
		
		setTitle("Credit-card processing Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);


		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		loadAccountTable();
	}
	
	private void loadAccountTable() {
		Map<String, CustomerCcard> accs = controller.loadAccounts();
		if(accs!=null) {
			for(CustomerCcard cus: accs.values()) {
				for(CcardAccount acc: cus.getCcards().values()) {
					rowdata[0] = cus.getName();
		            rowdata[1] = acc.getAccountNumber();
		            rowdata[2] = acc.getExp_date().toString();
		            rowdata[3] = acc.toString();
		            rowdata[4] = Double.toString(acc.getBalance());
		            model.addRow(rowdata);
				}
			}
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	public void run()
	{
		setVisible(true);
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();


	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == CcardView.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		AddCCAccount ccac = new AddCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		if (newaccount){
            // add row to table
            rowdata[0] = clientName;
            rowdata[1] = ccnumber;
            rowdata[2] = expdate;
            rowdata[3] = accountType;
            rowdata[4] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
            
    		System.out.println(controller.loadAccounts());
    		
    		LocalDate localDate;
    		int nZip;
    		int nCCnumber;
    		try {
    			localDate = LocalDate.parse(expdate);
    		}
    		catch(Exception e) {
    			localDate = LocalDate.now();
    		}
    		try {
    			nZip = Integer.parseInt(zip);
    		}
    		catch(Exception e) {
    			nZip = 0;
    		}
    		try {
    			nCCnumber = Integer.parseInt(ccnumber);
    		}
    		catch(Exception e) {
    			nCCnumber = 0;
    		}
    		
    		CustomerCcard customer = new CustomerCcard(clientName, street, city, state, email, nZip);
    		if (accountType == "Gold") {
    			customer = factory.createGoldAccount(clientName, street, city, state, nZip, email, ccnumber, localDate);
    		}
    		else {
    			if (accountType == "Silver") {
    				customer = factory.createSilverAccountt(clientName, street, city, state, nZip, email, ccnumber, localDate);
    			}
    			else {
    				customer = factory.createBronzeAccountt(clientName, street, city, state, nZip, email, ccnumber, localDate);
    			}
    		}

    		controller.addCustomer(clientName,customer);
    		
        }

    }

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill(thisframe);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);
            String ccnumber = (String)model.getValueAt(selection, 1);
		    //Show the dialog for adding deposit amount for the current mane
		    DepositDialog dep = new DepositDialog(thisframe,name);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    if(amountDeposit!=null && !amountDeposit.isEmpty()) {
			    // compute new amount
			    double deposit = Double.parseDouble(amountDeposit);
	            String samount = (String)model.getValueAt(selection, 4);
	            double currentamount = Double.parseDouble(samount);
	            double newamount=currentamount+deposit;
			    model.setValueAt(String.valueOf(newamount),selection, 4);
			    
			    try {
					controller.deposit(name, ccnumber, Double.valueOf(deposit));
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);
            String ccnumber = (String)model.getValueAt(selection, 1);
		    //Show the dialog for adding withdraw amount for the current mane
		    WithdrawDialog wd = new WithdrawDialog(thisframe,name);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    if(amountDeposit!=null && !amountDeposit.isEmpty()) {
			    // compute new amount
			    double deposit = Double.parseDouble(amountDeposit);
	            String samount = (String)model.getValueAt(selection, 4);
	            double currentamount = Double.parseDouble(samount);
	            double newamount=currentamount-deposit;
			    model.setValueAt(String.valueOf(newamount),selection, 4);
			    
			    try {
					controller.charge(name, ccnumber, Double.valueOf(deposit));
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BalanceInsufficientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			    if (newamount <0){
			       JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
			    }
		    }
		}
		
		
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


	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}
}
