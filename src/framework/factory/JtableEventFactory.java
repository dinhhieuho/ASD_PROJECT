package framework.factory;

import framework.observable.JtableListener;
import framework.observable.JtableView;
import framework.observable.Listener;
import framework.observable.Subject;
import framework.ui.GUI;

public class JtableEventFactory {

	private static Subject<Listener> subject = null;
	private static JtableListener observer = null;

	public static Subject<Listener> getInstance(GUI view) {
		if (subject == null) {
			subject = new JtableView<Listener>(view);
			observer = new JtableListener(subject);
			subject.subscribe(observer);
			return subject;
		}
		return subject;
	}

	
}
