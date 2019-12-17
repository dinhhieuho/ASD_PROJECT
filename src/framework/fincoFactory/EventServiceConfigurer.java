package framework.fincoFactory;

import framework.fincoobservable.FincoObserver;
import framework.fincoobservable.FincoSubject;
import framework.fincoobservable.FincoSubjectService;

/**
 * 
 * @author SARFO PHILIP
 * <a>Factory to instantiate the FincoSubject  which 
 * adds listeners to list of observers.</p>
 *
 */
public class EventServiceConfigurer {
	
	private static FincoSubject<FincoObserver> subject = new  FincoSubjectService<FincoObserver>();
	
	public EventServiceConfigurer() {
		start();
	}
	
	public void start() {
		if(subject == null) {
			subject = new FincoSubjectService<FincoObserver>();
		}
	}
	
	public static void addObserver(FincoObserver observer) {
		subject.subscribe(observer);
	}
	
	public static void notifyListeners() {
		subject.notifyChanged();
	}
}
