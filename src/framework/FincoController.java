package framework;

import framework.FincoObserverable.FincoSubject;
import framework.Notification.NotificationFactory;
import framework.Notification.NotificationManager;

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
