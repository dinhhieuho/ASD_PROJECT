package framework.dao;

import java.util.List;
import java.util.Optional;

import framework.customer.CustomerDefault;
import framework.db.Database;
import framework.observable.JtableViewObservable;
import framework.observable.Observable;
import framework.ui.TableView;

public class DataAccessService implements DataAccess {

	private Database<CustomerDefault> dbInstance = Database.getInstance();
	private Observable<TableView> subject;
	
	public DataAccessService() {
		
	}

	public DataAccessService(JtableViewObservable<TableView> subject ) {
		this.subject = subject;
	}
	
	@Override
	public void addCustomer(CustomerDefault customer) {
		dbInstance.add(customer);
		if(subject != null) {
			subject.setState();
		}
		System.out.println("Db Status: Customer created "+customer);
	}

	@Override
	public List<CustomerDefault> findAll() {
		return dbInstance;
	}

	@Override
	public void delete(CustomerDefault customer) {
		dbInstance.remove(customer);
	}

	@Override
	public Optional<CustomerDefault> findCustomerByName(String name) {
		return dbInstance.stream().filter(c->c.getName().equals(name)).findAny();
	}

	@Override
	public Optional<CustomerDefault> findAccountByAccountNumber(String accountNumber) {
		return dbInstance.stream().filter(c->c.findAccount(accountNumber) != null).findAny();
	}

	@Override
	public void setSubject(Observable<TableView> subject) {
		this.subject = subject;
		
	}

}
