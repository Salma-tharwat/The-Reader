import java.util.ArrayList;

public class User
{
	String Name;
	String UserName;
	String Password;
	
	ArrayList<User>Followers;
	
	ArrayList<abstractCategory>interests;
	ArrayList<Notification>Notifications;
	ArrayList<Book>Read_Books;
	ArrayList<Article>Created_Articles;
	public User(String name , String username, String password)
	{
		Name=name;
		UserName=username;
		Password=password;
		Followers=new ArrayList<User>();
		Notifications=new ArrayList<Notification>();
		interests=new ArrayList<abstractCategory>();
		Read_Books=new ArrayList<Book>();
		Created_Articles=new ArrayList<Article>();
	}
	public void AddFollower(User u)
	{
		Followers.add(u);
	}
	public void RemoveFollower(User u)
	{
		Followers.remove(u);
	}
	
	private void NotifyFollowers(Notification n)
	{
		
	}
	public void Notify (Notification n)
	{
		
	}
	public void  ReadBook(Book b)
	{
		
	}





}
