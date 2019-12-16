package framework;
public class NotificationFactory {
	public INotification createNotification() {
		return new Notification();
	}
}
