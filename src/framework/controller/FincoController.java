package framework.controller;

import java.util.Map;

import framework.FincoDAO;
import framework.FincoDataAccessFacotry;
import framework.FincoFactory;
import framework.fincoObserverable.FincoSubject;
import framework.notification.NotificationFactory;
import framework.notification.NotificationManager;

public abstract class FincoController {
	private NotificationFactory notificationFactory;
	private FincoDataAccessFacotry dbAccessFactory;
	private FincoFactory fincoFactory;
	private NotificationManager notificationManager;
	private FincoSubject subject;
	
	public abstract void actionHandler(Map<String, String> arg);
	
	public FincoDAO getDbInstance() {
		return dbAccessFactory.getDAOInstance();
	}
	
	public void setFincoFactory(FincoFactory fincoFactory) {
		this.fincoFactory = fincoFactory;
	}
	public FincoFactory getFincoFactory() {
		return fincoFactory;
	}

	public void actionHandler() {
		// TODO Auto-generated method stub
		
	}
}
