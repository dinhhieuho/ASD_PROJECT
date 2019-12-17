package framework.ui;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public abstract class FincoView extends JFrame {
	public abstract void run();
	public abstract void setTableModel(DefaultTableModel model);
	public abstract void updateTableModel(DefaultTableModel model);
}
