package framework.ui;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableView extends JTable{
	private Object [] tvColumns;
	private DefaultTableModel model;
	public TableView(Object [] tvColumns) {
		this.tvColumns = tvColumns;
		model = new DefaultTableModel(tvColumns, 1);
		setModel(model);
	}
	public void reloadTable(List<Object[]> data) {
		model = new DefaultTableModel(tvColumns, 1);
		data.forEach(row -> model.addRow(row));
		setModel(model);
	}
	
	public void setTableColumns(Object [] tvColumns) {
		this.tvColumns = tvColumns;
		setModel(model);
	}
	public DefaultTableModel getTvModel() {
		return this.model;
	}
	
}
