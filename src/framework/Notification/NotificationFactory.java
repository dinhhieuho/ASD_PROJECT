package framework.Notification;

public class NotificationFactory {
	public INotification createNotification() {
		return new Notification();
	}
}
