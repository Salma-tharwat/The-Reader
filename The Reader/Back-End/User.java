import java.text.MessageFormat;
import java.util.ArrayList;

public class User {
	String name;
	String userName;
	String password;
	ArrayList<User> followers;
	ArrayList<Category> interests;
	ArrayList<Notification> notifications;
	ArrayList<Book> readBooks;
	ArrayList<Article> createdArticles;

	public User(String name, String username, String password) {
		this.name = name;
		userName = username;
		this.password = password;
		followers = new ArrayList<User>();
		notifications = new ArrayList<Notification>();
		interests = new ArrayList<Category>();
		readBooks = new ArrayList<Book>();
		createdArticles = new ArrayList<Article>();
	}

	public boolean addFollower(User user) {
		Database db = Database.getInstance();
		return db.addUserFollower(this, user);
	}

	public void removeFollower(User u) {
		followers.remove(u);
	}

	public void notifyFollowers(Notification notification) {
		for (User follower : followers) {
			follower.notify(notification);
		}
	}

	public void notify(Notification notification) {
		Notification newNotification = notification.clone();
		newNotification.AddNotification(this);
	}

	public void readBook(Book book) {
		readBooks.add(book);
	}
	
	public void createdArticle(Article article){
		createdArticles.add(article);
	}
}
