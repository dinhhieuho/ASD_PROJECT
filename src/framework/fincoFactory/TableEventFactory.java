package framework.fincoFactory;

import framework.fincoobservable.FincoObserver;
import framework.fincoobservable.FincoSubject;
import framework.fincoobservable.FincoSubjectService;
import framework.fincoobservable.FincoTableObserver;
import framework.ui.FincoView;

/**
 * 
 * @author SARFO PHILIP
 * <a>Factory to instantiate the FincoSubject  which 
 * adds listeners to list of observers.</p>
 * {@code getInstance create a single instance of the observer and subject}
 *
 */
public class TableEventFactory {
	
	private static FincoSubject<FincoObserver> subject = null;
	private static FincoTableObserver observer = null;
	
	private static FincoSubject<FincoObserver> getInstance(FincoView view) {
		if(subject == null) {
			subject = new FincoSubjectService<FincoObserver>(view);	
			observer = new FincoTableObserver(subject);
			subject.subscribe(observer);
			return subject;
		}
		return subject;
	}
	
	public static void addObserver(FincoObserver observer) {
		subject.subscribe(observer);
	}
	
	public static void notifyTableListeners(FincoView view) {
		FincoSubject<FincoObserver> subject = getInstance(view);
		subject.notifyChanged();
	}
}
