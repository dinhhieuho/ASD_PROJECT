package framework.ui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import framework.controller.Controller;

public class DebitDialog extends JDialog {

	private Controller controller;
	String accnr;

	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new javax.swing.JLabel();
	JTextField JTextField_NAME = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_Debit = new JTextField();

	public DebitDialog(Controller controller, String accnr) {
		this.controller = controller;
		this.accnr = accnr;
		showDialog();
	}

	private void showDialog() {
		setTitle("Debit Account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setVisible(false);

		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		// JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JTextField_Debit);
		JTextField_Debit.setBounds(84, 48, 144, 24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		// parentframe.amountDeposit = JTextField_Deposit.getText();
		
		try {
			String response = controller.debit(Double.parseDouble(JTextField_Debit.getText()), JTextField_NAME.getText());
			if(response != null)
				JOptionPane.showMessageDialog(this, response);
			else
				JOptionPane.showMessageDialog(this, "Transaction completed successfully!");
			dispose();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid amount entered");
		}
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}
