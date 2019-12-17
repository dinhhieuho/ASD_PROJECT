package framework.notification;

public interface INotificationManager {
	public void submit(INotification notify);

	public void retry();
}
