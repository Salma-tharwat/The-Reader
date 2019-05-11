
public class ArticleNotification extends Notification {

	Article article;
	
	public ArticleNotification(String message, NotificationState notificationState, Article article) {
		super(message, notificationState);
		this.article = article;
	}

	@Override
	public void onclick() {
		View_Article_Window view = new View_Article_Window();
	}

	@Override
	public Notification clone() {
		Notification notification = new ArticleNotification(message, notificationState.clone(), article);
		return notification;
	}

}
