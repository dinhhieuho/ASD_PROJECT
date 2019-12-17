package framework.notification;
import java.util.ArrayList;
import java.util.List;

import framework.notification.INotificationManager;

public class NotificationManager implements INotificationManager {
	
	List<INotification> alertHistory = new ArrayList<INotification>();
	

	public void retry() {
		//get all the notifications with status =! "sent" and execute
		//you can add loacldate to check which period you want to retry
	}

	@Override
	public void submit(INotification notification) {
		notification.execute();
		notification.setStatus("sent");
		alertHistory.add(notification);
	}

}
