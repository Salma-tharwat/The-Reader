
public class Comment extends AbstractComment {

	public Comment(User user, String content) {
		super(user, content);
	}
	
	@Override
	public void notify(Notification notification) {
		user.notify(notification.clone());
	}

}
