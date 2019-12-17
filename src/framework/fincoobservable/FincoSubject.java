package framework.fincoobservable;

import framework.ui.FincoView;

public interface FincoSubject<T extends FincoObserver> {
	public abstract void subscribe(T observer);
	public void notifyChanged();
	public FincoView getState();
}
