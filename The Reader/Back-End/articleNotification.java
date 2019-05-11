
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

}
