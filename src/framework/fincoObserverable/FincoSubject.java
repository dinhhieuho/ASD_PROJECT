package framework.fincoObserverable;
import java.util.List;

public abstract class FincoSubject {
	List<FincoObserver> obs;
	
	public abstract void addSubscriber();
	public abstract void notifyChanged();

}
