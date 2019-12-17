package framework.Notification;

import framework.fincoCustomer.FincoCustomer;

public class NotificationFactory {
	public INotification createNotification(FincoCustomer customer, String accountNumber) {
		return new Notification(customer, accountNumber);
	}
}
