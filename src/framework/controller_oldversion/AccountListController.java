//package framework.controller_oldversion;
//
//import java.util.Map;
//
//import javax.swing.table.DefaultTableModel;
//
//import framework.account.Account;
//import framework.customer.Customer;
//import framework.dao.FincoDao;
//import framework.dao.FincoDaoImpl;
//import framework.ui.FincoView;
//
//public class AccountListController implements FincoController{
//	
//	FincoDao fincoDao = new FincoDaoImpl(); 
//
//	@Override
//	public void actionHandler(Map<String, String> arg, FincoView view) {
//		String[] rowdata = new String[4];
//       
//
//        DefaultTableModel model = new DefaultTableModel();
//        
//        model.addColumn("AccountNr");
//        model.addColumn("Name");
//        model.addColumn("City");
//        model.addColumn("Amount");
//        
//       
//       
//        for(Customer customer : fincoDao.findAll()) {
//        	Account account = customer.getAccounts()
//        				.entrySet().iterator().next().getValue();
//        	rowdata[0] = account.getAccountNumber();
//            rowdata[1] = customer.getName();
//            rowdata[2] = customer.getCity();
//            rowdata[3] = account.getBalance()+"";
//            model.addRow(rowdata);
//        }
//        
//
//        view.setTableModel(model);
//             
//	}
//	
//	public void refreshtable(DefaultTableModel model, FincoView view) {
//		String[] rowdata = new String[4];
//		System.out.println(model.getColumnCount());
//	       
////	        for(Customer customer : fincoDao.findAll()) {
////	        	Account account = customer.getAccounts()
////	        				.entrySet().iterator().next().getValue();
////	        	rowdata[0] = account.getAccountNumber();
////	            rowdata[1] = customer.getName();
////	            rowdata[2] = customer.getCity();
////	            rowdata[3] = account.getBalance()+"";
////	            model.addRow(rowdata);
////	        }
//	        
//
//	        view.setTableModel(model);
//	}
//
//}
