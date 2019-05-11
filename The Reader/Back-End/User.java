import java.util.ArrayList;

public class User 
{
	String name;
	String userName;
	String password;
	ArrayList<User> followers;
	ArrayList<Category> interests;
	ArrayList<Notification> notifications;
	ArrayList<Book> readBooks;
	ArrayList<Article> createdArticles;

	public User(String name, String username, String password) {
		name = name;
		userName = username;
		password = password;
		followers = new ArrayList<User>();
		notifications = new ArrayList<Notification>();
		interests = new ArrayList<Category>();
		readBooks = new ArrayList<Book>();
		createdArticles = new ArrayList<Article>();
	}

	public void AddFollower(User u) {
		followers.add(u);
	}

	public void RemoveFollower(User u) {
		followers.remove(u);
	}

	private void NotifyFollowers(Notification n) {

	}

	public void Notify(Notification n) {

	}

	public void ReadBook(Book b) {

	}

}
