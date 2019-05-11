import java.sql.*;
import java.util.ArrayList;  

public class Database {
	
	// Static instance of class to be used as Singleton design patterns
	static Database database;
	
	Statement stmt;

	String databaseName ;
	String username ;
	String password ;
	Connection conn;

	
	ArrayList<Article> articles;
	ArrayList<Book> books;
	ArrayList<Category> categories;
	ArrayList<User> users;
	
	public static Database getInstance() {
		if(database == null)
			return new Database();
		else
			return database;
	}
	
	private Database(){
		databaseName = "The_Reader";
		username = "root";
		password = "admin";
		
		if(initialize()) {
			System.out.println("happy");
		}
		else {
			System.out.println("SAD");
		}
	}
	
	private boolean initialize() {
		try 
		{		
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName,username, password);
			return true;
		}
		
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	ArrayList<Category> getAllCategories()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Category");
			ArrayList<Category>cats = new ArrayList<Category>();
			while(rs.next())
			{
				Category c = new Category(rs.getString(1));
				cats.add(c);
			}
			return cats;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	ArrayList<Book>getAllBooks()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Book");
			ArrayList<Book>myBooks = new ArrayList<Book>();
			while(rs.next())
			{
				Book b = new Book(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getString(2), rs.getString(5), rs.getString(6));
				myBooks.add(b);
			}
			return myBooks;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	ArrayList<User> getAllUsers()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from User");
			ArrayList<User>myUsers = new ArrayList<User>();
			while(rs.next())
			{
				User u = new User(rs.getString(3), rs.getString(1), rs.getString(2));
				myUsers.add(u);
			}
			return myUsers;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	User getUser(String user_name)
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from User where user_name = '"+user_name+"'");
			User user = null;
			while(rs.next())
			{
				user = new User(rs.getString(3), rs.getString(1), rs.getString(2));
			}
			return user;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	ArrayList<Article> getAllArticles()
	{
		try
		{
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from article");
			ArrayList<Article>myArticles = new ArrayList<Article>();
			while(rs.next())
			{
				Blob content = rs.getBlob(4);
				int length = (int) content.length();
				
				Article a = new Article(rs.getInt(1), rs.getString(2), rs.getDate(3), getUser(rs.getString(5)), content.getBytes(1,length));
				myArticles.add(a);
			}
			return myArticles;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
