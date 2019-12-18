package framework.fincoAccount;

import java.util.Stack;

import framework.fincoEntry.Entry;

/**
 * Finco Account interfaces client's Account
 * @author SARFO PHILIP
 *
 */
public interface FincoAccount {
	
	/**
	 * {@code addEntry creates new entry for account}
	 * @param entry
	 */
	public void addEntry(Entry entry);
	public Stack<Entry> getEntry();
	
	public String  getAccountType();
	public void addInterest();

}
