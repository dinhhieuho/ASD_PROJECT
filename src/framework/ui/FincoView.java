package framework.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public abstract class FincoView extends JFrame {
	public abstract void run();
	public abstract void setTableModel(DefaultTableModel model);
	public abstract void updateTableModel(DefaultTableModel model);
	public abstract void addTopButton(JButton button);
	public abstract void addRightButton(JButton button);
	public void setFincoViewTitle(String title) {
		// TODO Auto-generated method stub
		
	}
}
