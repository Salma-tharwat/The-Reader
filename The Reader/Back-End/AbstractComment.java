import java.util.ArrayList;

public abstract class AbstractComment {
	
	int id;
	User user;
	String content;
	ArrayList<AbstractComment> replies;

	public AbstractComment(int id, User user, String content) {
		this.id = id;
		this.user = user;
		this.content = content;
		replies = new ArrayList<AbstractComment>();
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

	public void addReply(AbstractComment reply) {
		replies.add(reply);
	}

	public abstract void notify(Notification notification);
}
