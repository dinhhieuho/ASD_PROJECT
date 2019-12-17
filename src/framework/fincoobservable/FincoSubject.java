package framework.fincoobservable;

public interface FincoSubject<T extends FincoObserver> {
	public abstract void subscribe(T observer);
	public abstract void notifyChanged();
}
