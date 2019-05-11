
public class UserNotification extends Notification {

	User user;
	
	public UserNotification(String message, NotificationState notificationState, User user) {
		super(message, notificationState);
		this.user = user;
	}

	@Override
	public void onclick() {
		View_User_Window view = new View_User_Window(user);
	}

	@Override
	public Notification clone() {
		Notification notification = new UserNotification(message, notificationState.clone(), user);
		//todo : get notfication id from database
		return notification;
	}
	
}
