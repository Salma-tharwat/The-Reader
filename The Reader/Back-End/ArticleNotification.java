
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
		// TODO : get notfication id from database
		return notification;
	}

	@Override
	public boolean AddNotification(User user) {
		Database db = Database.getInstance();
		return db.addArticleNotification(user, this);
	}

}
