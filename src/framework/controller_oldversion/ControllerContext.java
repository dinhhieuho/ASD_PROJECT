/*
 * package framework.controller_oldversion;
 * 
 * import java.awt.event.ActionEvent; import java.util.HashMap; import
 * java.util.Map;
 * 
 * import javax.swing.JOptionPane;
 * 
 * import framework.ui.FincoView;
 * 
 * public class ControllerContext { FincoController controller = new
 * CustomerController(); FincoController debController = new DebitController();
 * FincoController credController = new CreditController(); FincoController
 * accountListController = new AccountListController();
 * 
 * private FincoView context; private HashMap<String, FincoController>
 * cRegister;
 * 
 * public ControllerContext(FincoView context) { this.context = context;
 * cRegister = new HashMap<String, FincoController>(); }
 * 
 * public void debitAccount(String accNumber, double amount) { Map<String,
 * String> arg = new HashMap<String, String>();
 * 
 * arg.put("accNumber",String.valueOf(accNumber));
 * arg.put("amount",String.valueOf(amount));
 * 
 * debController.actionHandler(arg,context); }
 * 
 * public void creditAccount(String accNumber, double amount) {
 * 
 * Map<String, String> arg = new HashMap<String, String>();
 * 
 * //arg.put("name",customerName); arg.put("accNumber",accNumber);
 * arg.put("amount",String.valueOf(amount));
 * 
 * credController.actionHandler(arg,context); }
 * 
 * public void populateAccounts() { accountListController.actionHandler(null,
 * context); }
 * 
 * public void registerPerformer(FincoController fc, String cmdId) {
 * cRegister.put(cmdId, fc);
 * 
 * }
 * 
 * public void actionEventHandler(ActionEvent e, HashMap<String, String> data) {
 * //System.out.println(e.getActionCommand());
 * if(cRegister.get(e.getActionCommand()) != null) {
 * cRegister.get(e.getActionCommand()).actionHandler(data, context); } else {
 * System.out.println("No match"); System.out.println(cRegister); } }
 * 
 * }
 */