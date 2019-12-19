package framework.observable;

import java.util.ArrayList;
import java.util.List;

import framework.ui.FincoView;

public class JtableView<T  extends Listener> implements Subject<T>{
	
	
	private List<T> observers = new ArrayList<>();
	
	private FincoView state;
	
	public JtableView(FincoView state) {
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
