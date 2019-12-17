package framework.notification;

import framework.FincoCustomer;

public class NotificationFactory {
	public INotification createNotification(FincoCustomer customer, String accountNumber) {
		return new Notification(customer, accountNumber);
	}
}
