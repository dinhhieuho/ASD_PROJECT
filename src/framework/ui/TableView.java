package framework.ui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.observable.Listener;
import framework.observable.Observable;

public class TableView extends JTable implements Listener{
	private Object [] tvColumns;
	private Observable<TableView> subject;
	private DefaultTableModel model;
	public TableView(Object [] tvColumns) {
		this.tvColumns = tvColumns;
		model = new DefaultTableModel(tvColumns, 0);
		setModel(model);
	}
	
	public TableView(Object [] tvColumns, Observable<TableView> subject) {
		this.tvColumns = tvColumns;
		subject.subscribe(this);
		this.subject = subject;
		model = new DefaultTableModel(tvColumns, 1);
		setModel(model);
	}
	
	public void reloadTable(List<Object[]> data) {
		model = new DefaultTableModel(tvColumns, 0);
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
	@Override
	public void update() {
		reloadTable(subject.getState());
	}
	
	public void update(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
}
