package creditcard.customer;

import java.util.HashMap;
import java.util.Map;

import creditcard.account.CcardAccount;
import framework.account.Account;
import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.entry.EntryDefault;
import framework.exceptions.AccountNotFoundException;
import framework.exceptions.BalanceInsufficientException;

public class CustomerCcard extends CustomerDefault {

	private HashMap<String, CcardAccount> accounts = new HashMap<String, CcardAccount>();
	private String name;
	public CustomerCcard(String name, String street, String city, String state, String email, int zip) {
		super(name, street, city, state, email, zip);
		this.name = name;
	}
	public HashMap<String, CcardAccount> getCcards() {
		return accounts;
	}
	public CustomerCcard addAccount(CcardAccount account) {
		accounts.put(name, account);
		return this;
	}

	public void removeAccount(CcardAccount account) {
		accounts.remove(account);
	}
	
	@Override
	public void debit(String accountNumber, double amount)
			throws AccountNotFoundException, BalanceInsufficientException {
		CcardAccount account = accounts.get(accountNumber);
		if (account == null) {
			throw new AccountNotFoundException("Account Not Found");
		}
		if (account.getBalance() < amount) {
			throw new BalanceInsufficientException("Balance Insufficient");
		} else {
			account.setPrevious_balance(account.getBalance());
			account.addCharge(amount);
			double balanceLeft = account.getBalance() - amount;
			account.setBalance(balanceLeft);
			account.addEntry(new EntryDefault(amount, "debited"));
		}

	}

	@Override
	public void credit(String accountNumber, double amount) throws AccountNotFoundException {
		CcardAccount account = accounts.get(accountNumber);
		if (account != null) {
			double balance = account.getBalance() + amount;
			account.setBalance(balance);
			account.addEntry(new EntryDefault(amount, "credited"));
		} else {
			throw new AccountNotFoundException("Account Not Found");
		}

	}
}
