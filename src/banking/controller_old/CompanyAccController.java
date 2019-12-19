package banking.controller_old;
//package banking;
//
//import java.util.Map;
//import java.util.Optional;
//
//import javax.swing.JOptionPane;
//
//import framework.controller_oldversion.FincoController;
//import framework.customer.Customer;
//import framework.dao.FincoDao;
//import framework.dao.FincoDaoImpl;
//import framework.factory.FincoFactory;
//import framework.factory.TableEventFactory;
//import framework.ui.FincoView;
//
//public class CompanyAccController implements FincoController {
//
//	private BankFactory fincoFactory = new CompanyFactory();
//	private FincoDao fincoDao = new FincoDaoImpl();
//
//	public void actionHandler(Map<String, String> arg, FincoView view) {
//		try {
//			Optional<Customer> customer = fincoDao.findAccountByAccountNumber(arg.get("accountNumber"));
//			if (!customer.isPresent()) {
//				Customer cust = fincoFactory.createCustomer(arg.get("name"), arg.get("street"), arg.get("city"),
//						arg.get("state"), Integer.parseInt(arg.get("zip")), arg.get("email"), arg.get("accountNumber"),
//						arg.get("acctype"), Integer.parseInt(arg.get("numemps")));
//
//				// Save in dao
//				fincoDao.addCustomer(cust);
//
//				JOptionPane.showMessageDialog(view, "Account Created");
//
//				// Update table view
//				TableEventFactory.notifyTableListeners(view);
//
//			} else {
//				JOptionPane.showMessageDialog(view, "Account Exists Already");
//			}
//
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(view, "Invalid number format");
//		}
//
//	}
//
//}
