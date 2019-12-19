package framework.observable;

import framework.ui.GUI;

public interface Subject<T extends Listener> {
	
	public abstract void subscribe(T observer);

	public void notifyChanged();

	public GUI getState();
}
