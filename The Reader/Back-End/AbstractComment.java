import java.util.ArrayList;

public abstract class AbstractComment {
	
	User user;
	String content;
	ArrayList<Comment> replies;

	public AbstractComment(User user, String content) {
		this.user = user;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

	public void addReply(Comment reply) {
		replies.add(reply);
	}

	public abstract void Notify();
}
