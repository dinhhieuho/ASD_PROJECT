package framework.fincoAccount;

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

}
