
public class Comment extends AbstractComment {

	public Comment(int id, User user, String content) {
		super(id, user, content);
	}
	
	@Override
	public void notify(Notification notification) {
		user.notify(notification.clone());
	}

}
