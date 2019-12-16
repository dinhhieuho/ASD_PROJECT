package framework.notification;

public class NotificationFactory {
	public INotification createNotification() {
		return new Notification();
	}
}
