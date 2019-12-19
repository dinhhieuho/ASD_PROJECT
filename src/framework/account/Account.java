package framework.account;

import java.util.Stack;

import framework.entry.Entry;

/**
 * Finco Account interfaces client's Account
 * @author SARFO PHILIP
 *
 */
public interface Account {
	
	/**
	 * {@code addEntry creates new entry for account}
	 * @param entry
	 */
	public void addEntry(Entry entry);
	public Stack<Entry> getEntry();
	
	public String  getAccountType();
	public void addInterest();

}
