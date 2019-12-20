package creditcard.controller;

import java.util.List;
import creditcard.account.CcardAccount;
import creditcard.customer.CustomerCcard;
import creditcard.dataacess.CardDataAccess;
import framework.controller.Controller;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;

public  class CcardController extends Controller{
	
	public DataAccess dataAccess;
	private CardDataAccess access = new CardDataAccess();
	
	public CcardController(DataAccess dataAccess) {
		super(dataAccess);
		
	}

	
	@Override
	public <T extends CustomerDefault> void addCustomer(T customer) {
		access.addCustomer(customer);
	}
	
	public List<CustomerCcard> loadCardAccounts(){
		return access.dbInstance;
	}
	
	
	public String cardReport() {
		String billstring="";
		// generate the string for the monthly bill
		List<CustomerCcard> customerList = loadCardAccounts();
		
		
		for(CustomerCcard customer : customerList) {
				for(CcardAccount acc : customer.getCcards().values()) {
					billstring += customer.toString();
					billstring += "CC number= "+acc.getCC_number()+"\r\n";
					billstring += "CC type= "+acc.toString()+"\r\n";
					billstring += "Previous balance = $ "+acc.getPrevious_balance()+"\r\n";
					billstring += "Total Credits = $ "+acc.getTotal_credits()+"\r\n";
					billstring += "Total Charges = $ "+acc.getTotal_charges()+"\r\n";
				billstring += "New balance = $ "+acc.computeNewBalance()+"\r\n";
					billstring += "Total amount due = $ "+acc.computeTotal_due()+"\r\n";		
					billstring += "\r\n";		
					billstring += "\r\n";
				}
			
		}
		return billstring;
	}
}
