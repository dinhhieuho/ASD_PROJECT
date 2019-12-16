package framework;

import framework.fincoObserverable.FincoSubject;
import framework.notification.NotificationFactory;
import framework.notification.NotificationManager;

public abstract class FincoController {
	private NotificationFactory notificationFactory;
	private FincoDataAccessFacotry dbAccessFactory;
	private FincoFactory fincoFactory;
	private NotificationManager notificationManager;
	private FincoSubject subject;
	
	public abstract void actionHandler();
	
	public FincoDAO getDbInstance() {
		return dbAccessFactory.getDAOInstance();
	}
	
}
