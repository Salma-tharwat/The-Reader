
public class articleNotification extends Notification {

	Article article;
	
	public articleNotification(String message, NotificationState notificationState, Article article) {
		super(message, notificationState);
		this.article = article;
	}

	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notification clone() {
		Notification notification = new articleNotification(message, notificationState.clone(), article);
		return notification;
	}

}
