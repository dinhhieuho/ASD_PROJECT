package framework.fincoobservable;

import framework.controller.ControllerContext;
import framework.ui.FincoView;

public class FincoTableObserver implements FincoObserver {
	
	private FincoSubject<FincoObserver> subject;
	
	public FincoTableObserver(FincoSubject<FincoObserver> subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		FincoView view = subject.getState();
		ControllerContext context = new ControllerContext(view);
        context.populateAccounts();
        
        System.out.println("Finco [INFO]: Table event triggered!!");
	}

}
