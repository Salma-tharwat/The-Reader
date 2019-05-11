
public class BookNotfication extends Notification {

	Book book;
	
	public BookNotfication(String message, NotificationState notificationState, Book book) {
		super(message, notificationState);
		this.book = book;
	}

	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notification clone() {
		Notification notification = new BookNotfication(message, notificationState.clone(), book);
		return notification;
	}
	
}