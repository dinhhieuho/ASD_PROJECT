package banking;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.ui.FincoDefaultView;
import framework.ui.MainViewFW;

public class BankView extends MainViewFW{
	private BankController report;
	
	
	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	
	String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
	
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    BankView myframe;
    private Object rowdata[];
	
	public BankView(){
		super("Bank Application");
		myframe = this;
		rowdata = new Object[8];
		newaccount=false;
		
		initialize();
	}
	
	private void initialize() {
		
		//////////////
		model = new DefaultTableModel();
    	model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        
        setTableModel(model);
        JTable1 = getTable();
        
        JButton_PerAC.setText("Add personal account");
        
    	JButton_CompAC.setText("Add company account");
    	
    	JButton_Addinterest.setText("Add interest");
    	
    	addTopButton(JButton_PerAC);
    	addTopButton(JButton_CompAC);
    	addTopButton(JButton_Addinterest);
        
    	JButton_Deposit.setText("Deposit");
    	JButton_Withdraw.setText("Withdraw");
    	JButton_Exit.setText("Exit");
    	
    	addRightButton(JButton_Deposit);
    	addRightButton(JButton_Withdraw);
    	addRightButton(JButton_Exit);
    	
    	buildGUI();
		//////////////

		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
	}
	

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		AddPerson pac = new AddPerson(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "P";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }
    }

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		AddCompany pac = new AddCompany(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		
		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount-deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 5);
		    if (newamount <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }
		}
		
		
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	    
	}
}
