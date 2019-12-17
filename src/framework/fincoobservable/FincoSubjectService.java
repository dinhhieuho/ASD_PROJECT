package framework.fincoobservable;

import java.util.ArrayList;
import java.util.List;

import framework.fincoCustomer.Customer;

public class FincoSubjectService<T  extends FincoObserver> implements FincoSubject<T>{
	
	
	private List<T> observers = new ArrayList<>();
	
	private Customer state;

	@Override
	public void subscribe(T observer) {
		observers.add(observer);
	}

	@Override
	public void notifyChanged() {
		for(T t : observers)
			 t.update();	
	}
		
	public Customer getState() {
		return state;
	}
	


}
