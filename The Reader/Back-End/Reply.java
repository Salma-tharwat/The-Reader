
public class Reply extends AbstractComment {
	AbstractComment parent;

	public Reply(int id, User user, String content, AbstractComment parent) {
		super(id, user, content);
		this.parent = parent;
	}
	
	@Override
	public void notify(Notification notification) {
		user.notify(notification);
		parent.notify(notification);
	}

}
