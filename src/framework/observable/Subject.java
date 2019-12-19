package framework.observable;

import framework.ui.FincoView;

public interface Subject<T extends Listener> {
	
	public abstract void subscribe(T observer);

	public void notifyChanged();

	public FincoView getState();
}
