package framework.controller;

import java.util.Map;

import javax.swing.table.DefaultTableModel;

import framework.dao.FincoDao;
import framework.dao.FincoDaoImpl;
import framework.fincoCustomer.Customer;
import framework.ui.FincoView;

public class AccountListController implements FincoController{
	
	FincoDao fincoDao = new FincoDaoImpl(); 

	@Override
	public void actionHandler(Map<String, String> arg, FincoView view) {
		String[][] rowData = {};
        String[] column = {"AccountNr","Name","City","Amount"};
        
		
        
        
        System.out.println(fincoDao.findAll().size());
       
        for(int i = 0; i < fincoDao.findAll().size()-1; i++) {
        	 rowData[i] = new String[] {"a","b","c","r"};
        	 System.out.println(rowData);
        }
        DefaultTableModel model = new DefaultTableModel(rowData,column);
    	
    	
        view.setTableModel(model);
        
        
	}

}
