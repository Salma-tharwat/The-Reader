
public class ArticleNotification extends Notification {

	Article article;
	
	public ArticleNotification(String message, NotificationState notificationState, Article article) {
		super(message, notificationState);
		this.article = article;
	}

	@Override
	public void onclick() {
		Database db = Database.getInstance();
		notificationState = NotificationStateFactory.getNotification(NotificationStateTypes.seen);
		db.updateArticleNotification(this);
		View_Article_Window view = new View_Article_Window(article);
		view.setVisible(true);
	}

	@Override
	public Notification clone() {
		Database db = Database.getInstance();
		Notification notification = new ArticleNotification(message, notificationState.clone(), article);
		notification.id = db.getNextNotificationId();
		return notification;
	}

	@Override
	public boolean AddNotification(User user) {
		Database db = Database.getInstance();
		return db.addArticleNotification(user, this);
	}

}
