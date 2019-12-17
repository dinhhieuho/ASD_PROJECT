package creditcard;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import framework.ui.MainViewFW;

public class CcardView extends MainViewFW {
	/****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CcardView thisframe;
    private Object rowdata[];
    
    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
    
	public CcardView()
	{
		super("Credit-card processing Application");
		thisframe=this;
		
		rowdata = new Object[7];
        newaccount=false;
		
		initialize();
		
	}

	private void initialize() {

        model = new DefaultTableModel();
        
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        
        
        setTableModel(model);
        
        JTable1 = getTable();
		
		JButton_NewCCAccount.setText("Add Credit-card account");
		
		JButton_GenBill.setText("Generate Monthly bills");
		
		addTopButton(JButton_NewCCAccount);
    	addTopButton(JButton_GenBill);
		
		JButton_Deposit.setText("Deposit");
		JButton_Withdraw.setText("Charge");
		JButton_Exit.setText("Exit");

		addRightButton(JButton_Deposit);
    	addRightButton(JButton_Withdraw);
    	addRightButton(JButton_Exit);
    	
    	buildGUI();

		SymAction lSymAction = new SymAction();
		
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
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
		
		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
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
        }

       
        
    }

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(thisframe,name);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
		    
		}
		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String name = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,name);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
		    long newamount=currentamount-deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
		    if (newamount <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }
		}
		
		
	}
}
