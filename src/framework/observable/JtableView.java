package framework.observable;

import java.util.ArrayList;
import java.util.List;

import framework.ui.GUI;

public class JtableView<T extends Listener> implements Subject<T> {

	private List<T> observers = new ArrayList<>();

	private GUI state;

	public JtableView(GUI state) {
		this.state = state;
	}

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
	public GUI getState() {
		return state;
	}

}
