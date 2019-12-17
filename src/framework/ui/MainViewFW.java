package framework.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import banking.BankView;


public class MainViewFW extends FincoDefaultView {
	List<JButton> topButtons = new ArrayList();
	List<JButton> rightButtons = new ArrayList();
	
	JButton JButton_Exit = new JButton();
	
	JPanel JPanel1 = new JPanel();
	
	private JTable JTable1;
    private JScrollPane JScrollPane1;
    
    private String title;
    //ActionListener AL;
    
    public MainViewFW() {
    	buildDefaultView();
    }
    
    public MainViewFW(String title) {
    	this.title = title;
    	//this.AL = AL;
    }
    
    private void buildDefaultView() {
    	
    	title = "Bank Application Default View";
    	
    	DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        
        setTableModel(model);
        
        
        JButton JButton_PerAC = new JButton();
        JButton_PerAC.setText("Add personal account");
        
    	JButton JButton_CompAC = new JButton();
    	JButton_CompAC.setText("Add company account");
    	
    	JButton JButton_Addinterest= new JButton();
    	JButton_Addinterest.setText("Add interest");
    	
    	addTopButton(JButton_PerAC);
    	addTopButton(JButton_CompAC);
    	addTopButton(JButton_Addinterest);
        
    	JButton JButton_Deposit = new JButton();
    	JButton_Deposit.setText("Deposit");
    	JButton JButton_Withdraw = new JButton();
    	JButton_Withdraw.setText("Withdraw");
    	
    	addRightButton(JButton_Deposit);
    	addRightButton(JButton_Withdraw);
    	
    	buildGUI();
    	
		/*SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		*/
    }
	
	public void addTopButton(JButton btn) {
		topButtons.add(btn);
	}
	
	public void addRightButton(JButton btn) {
		rightButtons.add(btn);
	}
	
	public void setTableModel(DefaultTableModel model) {
		JTable1 = new JTable(model);
	}
	public JTable getTable() {
		return JTable1;
	}
	public void buildGUI() {
		setTitle(title);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		
		JScrollPane1 = new JScrollPane();
		
		JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
        
        //Add Top buttons
       
        int count = 0;
        for(JButton btn: topButtons) {
        	JPanel1.add(btn);
        	btn.setBounds(24*(count*10),20,192,33);
        	btn.setActionCommand("jbutton");
        	count++;
        }
        
        count = 0;
        for(JButton btn: rightButtons) {
        	JPanel1.add(btn);
        	btn.setBounds(468,104+(count*60),96,33);
        	btn.setActionCommand("jbutton");
        	count++;
        }
        
        //Add Exit button
        /*JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		*/
		this.addWindowListener(new SymWindow());
		
	}
	
	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainViewFW.this)
				MainViewFW_windowClosing(event);
		}
	}
	void MainViewFW_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		MainViewFW_windowClosing_Interaction1(event);
	}
	void MainViewFW_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}
	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}
}
