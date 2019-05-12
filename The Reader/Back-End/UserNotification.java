import java.util.logging.FileHandler;

public class UserNotification extends Notification {

	User user;
	
	public UserNotification(String message, NotificationState notificationState, User user) {
		super(message, notificationState);
		this.user = user;
	}

	@Override
	public void onclick() {
		Database db = Database.getInstance();
		notificationState = new SeenNotification();
		db.updateUserNotification(this);
		View_User_Window view = new View_User_Window(user);
		view.setVisible(true);
	}

	@Override
	public Notification clone() {
		Database db = Database.getInstance();
		Notification notification = new UserNotification(message, notificationState.clone(), user);
		notification.id = db.getNextNotificationId();
		return notification;
	}

	@Override
	public boolean AddNotification(User user) {
		Database db = Database.getInstance();
		return db.addUserNotification(user, this);
	}
	
}
