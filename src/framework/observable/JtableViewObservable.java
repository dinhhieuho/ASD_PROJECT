package framework.observable;

import java.util.ArrayList;
import java.util.List;

import framework.account.AccountDefault;
import framework.customer.CustomerDefault;
import framework.dao.DataAccess;
import framework.dao.DataAccessService;
import framework.ui.GUI;

public class JtableViewObservable<T extends Listener> implements Observable<T> {

	private List<T> observers = new ArrayList<>();

	private List<Object[]> state;

	private DataAccess fincoDao = new DataAccessService();

	@Override
	public void subscribe(T observer) {
		observers.add(observer);
	}

	@Override
	public void notifyChanged() {
		for (T t : observers)
			t.update();
	}

	@Override
	public List<Object[]> getState() {
		return state;
	}

	@Override
	public void setState() {
		List<Object[]> data = new ArrayList<Object[]>();
		for (CustomerDefault customer : fincoDao.findAll()) {
			Object [] rowdata = new Object[5];
			AccountDefault account = customer.getAccounts().entrySet().iterator().next().getValue();
			rowdata[0] = account.getAccountNumber();
			rowdata[1] = customer.getName();
			rowdata[2] = customer.getCity();
			rowdata[3] = String.valueOf(account.getBalance());
			data.add(rowdata); 	
		}
		this.state = data;
		notifyChanged();
		
	}

	//this part uses push to notify the observers
	//the observable doesn't store the state// 
	public void setState(String alert) {
		notifyChanged(alert);
	}

	public void notifyChanged(String s) {
		for (T t : observers)
			t.update(s);
	}
	
}
