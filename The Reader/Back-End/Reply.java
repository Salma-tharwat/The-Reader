
public class Reply extends AbstractComment {
	AbstractComment parent;

	public Reply(User user, String content, AbstractComment parent, Notification notification) {
		super(user, content);
		this.parent = parent;
		parent.notify(notification.clone());
	}
	
	@Override
	public void notify(Notification notification) {
		user.notify(notification.clone());
		parent.notify(notification.clone());
	}

}
