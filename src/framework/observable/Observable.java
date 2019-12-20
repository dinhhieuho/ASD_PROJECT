package framework.observable;

import java.util.List;

public interface Observable<T extends Listener> {
	
	public abstract void subscribe(T observer);

	public void notifyChanged();

	public List<Object[]> getState();
	public void setState();
	public void setState(String s);
}
