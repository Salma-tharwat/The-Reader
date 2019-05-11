
public class BookNotfication extends Notification {

	Book book;
	
	public BookNotfication(String message, NotificationState notificationState, Book book) {
		super(message, notificationState);
		this.book = book;
	}

	@Override
	public void onclick() {
		View_Book_Window view = new View_Book_Window(book);
	}

	@Override
	public Notification clone() {
		Notification notification = new BookNotfication(message, notificationState.clone(), book);
		//todo : get notfication id from database
		return notification;
	}
	
}
