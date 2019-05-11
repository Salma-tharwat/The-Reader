
public class UserNotification extends Notification {

	User user;
	
	public UserNotification(String message, NotificationState notificationState, User user) {
		super(message, notificationState);
		this.user = user;
	}

	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notification clone() {
		Notification notification = new UserNotification(message, notificationState.clone(), user);
		return notification;
	}
	
}
