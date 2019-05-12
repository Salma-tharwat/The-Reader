
public class BookNotfication extends Notification {

	Book book;
	
	public BookNotfication(String message, NotificationState notificationState, Book book) {
		super(message, notificationState);
		this.book = book;
	}

	@Override
	public void onclick() {
		View_Book_Window view = new View_Book_Window(book);
		view.setVisible(true);
	}

	@Override
	public Notification clone() {
		Database db = Database.getInstance();
		Notification notification = new BookNotfication(message, notificationState.clone(), book);
		notification.id = db.getNextNotificationId();
		return notification;
	}

	@Override
	public boolean AddNotification(User user) {
		Database db = Database.getInstance();
		return db.addBookNotification(user, this);
	}
	
}
