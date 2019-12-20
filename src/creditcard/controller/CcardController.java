
package creditcard.controller;

import java.util.List;
import java.util.Optional;

import creditcard.account.CcardAccount;
import creditcard.customer.CustomerCcard;
import creditcard.dataacess.CardDataAccess;
import framework.controller.Controller;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class CcardController extends Controller {

	public DataAccess dataAccess;
	private CardDataAccess access = new CardDataAccess();

	public CcardController(DataAccess dataAccess) {
		super(dataAccess);

	}

	public void addCardCustomer(CustomerCcard customer) {
		access.saveCustomer(customer);
	}

	public List<CustomerCcard> loadCardAccounts() {
		return access.loadCustomers();
	}

	@Override
	public String credit(double amount, String accountNumber) {
		String response = null;
		Optional<CustomerCcard> customer = access.findAccountByAccountNumber(accountNumber);
		if (customer.isPresent()) {
			try {
				customer.get().credit(accountNumber, amount);
				response = "deposit";
			} catch (AccountNotFoundException e) {

				response = "Account Not Found"; // not reached
			}
		} else
			response = "Account Not Found";
		return response;
	}

	@Override
	public String debit(double amount, String accountNumber) {
		String response = null;
		Optional<CustomerCcard> customer = access.findAccountByAccountNumber(accountNumber);

		if (customer.isPresent()) {
			try {
				customer.get().debit(accountNumber, amount);
				response = "Debitted";
			} catch (AccountNotFoundException | BalanceInsufficientException e) {

				response = "Insufficient Balance";
			}
		} else
			response = "Account Not Found";
		return response;
	}

	public String cardReport() {
		String billstring = "";
		// generate the string for the monthly bill
		List<CustomerCcard> customerList = loadCardAccounts();

		for (CustomerCcard customer : customerList) {
			for (CcardAccount acc : customer.getCcards().values()) {
				billstring += customer.toString();
				billstring += "CC number= " + acc.getCC_number() + "\r\n";
				billstring += "CC type= " + acc.getAccountType() + "\r\n";
				billstring += "Previous balance = $ " + acc.getPrevious_balance() + "\r\n";
				billstring += "Total Credits = $ " + acc.getTotal_credits() + "\r\n";
				billstring += "Total Charges = $ " + acc.getTotal_charges() + "\r\n";
				billstring += "New balance = $ " + acc.computeNewBalance() + "\r\n";
				billstring += "Total amount due = $ " + acc.computeTotal_due() + "\r\n";
				billstring += "\r\n";
				billstring += "\r\n";
			}

		}
		return billstring;
	}
}
