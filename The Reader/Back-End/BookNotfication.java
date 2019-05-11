
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
	
}
