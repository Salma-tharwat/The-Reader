import java.util.Date;

public class Book extends Publication {
	String hyperlink;
	String author;
	String description;

	public Book(int id, String name, Date datePublished, String Author, String hyperlink, String description) {
		super(id, name, datePublished);
		this.author = Author;
		this.description = description;
		this.hyperlink = hyperlink;
	}

	public Book() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void notifyFollowers(Notification notification) {
		for (User follower : followers)
			follower.notify(notification);
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addFollower(User user) {
		Database db = Database.getInstance();
		return db.addBookFollower(this, user);
	}

}
