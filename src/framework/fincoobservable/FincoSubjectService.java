package framework.fincoobservable;

import java.util.ArrayList;
import java.util.List;

import framework.customer.Customer;
import framework.ui.FincoView;

public class FincoSubjectService<T  extends FincoObserver> implements FincoSubject<T>{
	
	
	private List<T> observers = new ArrayList<>();
	
	private FincoView state;
	
	public FincoSubjectService(FincoView state) {
		this.state = state;
	}

	@Override
	public void subscribe(T observer) {
		observers.add(observer);
	}

	@Override
	public void notifyChanged() {
		for(T t : observers)
			 t.update();	
	}
	
	@Override
	public FincoView getState() {
		return state;
	}
	
	
	


}
