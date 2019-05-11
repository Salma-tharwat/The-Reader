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

	public void addFollower(User u) {
		followers.add(u);
	}

	public void removeFollower(User u) {
		followers.remove(u);
	}

	private void notifyFollowers(Notification notification) {
		for (User follower : followers) {
			follower.notify(notification.clone());
		}
	}

	public void notify(Notification notification) {
		notifications.add(notification);
	}

	public void readBook(Book book) {
		readBooks.add(book);
		notifyFollowers(new BookNotfication(MessageFormat.format("User {0} read book {1}", name, book.name), new NotSeenNotification(), book) );
	}
	
	public void createdArticle(Article article){
		createdArticles.add(article);
		notifyFollowers(new ArticleNotification(MessageFormat.format("User {0} created article {1}", name, article.name), new NotSeenNotification(), article));
	}
}
