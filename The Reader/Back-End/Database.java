import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;

public class Database {

	// Static instance of class to be used as Singleton design patterns
	static Database database;

	Statement stmt;
	PreparedStatement preparedStatement;
	String databaseName;
	String username;
	String password;
	Connection conn;

	ArrayList<Article> articles;
	ArrayList<Book> books;
	ArrayList<Category> categories;
	ArrayList<User> users;

	public static Database getInstance() {
		if (database == null)
			return new Database();
		else
			return database;
	}

	private Database() {
		databaseName = "The_Reader";
		username = "root";
		password = "admin";

		initialize();

		articles = getAllArticles();
		books = getAllBooks();
		categories = getAllCategories();
		users = getAllUsers();
	}

	private boolean initialize() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, username, password);
			return true;
		}

		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	ArrayList<Category> getAllCategories() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Category");
			ArrayList<Category> cats = new ArrayList<Category>();
			while (rs.next()) {
				Category c = new Category(rs.getString(1));
				cats.add(c);
			}
			return cats;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	ArrayList<Book> getAllBooks() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Book");
			ArrayList<Book> myBooks = new ArrayList<Book>();
			while (rs.next()) {
				Book b = new Book(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getString(2), rs.getString(5),
						rs.getString(6));
				myBooks.add(b);
			}
			return myBooks;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	ArrayList<User> getAllUsers() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from User");
			ArrayList<User> myUsers = new ArrayList<User>();
			while (rs.next()) {
				User u = new User(rs.getString(3), rs.getString(1), rs.getString(2));
				myUsers.add(u);
			}
			return myUsers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	User getUser(String user_name) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from User where user_name = '" + user_name + "'");
			User user = null;
			while (rs.next()) {
				user = new User(rs.getString(3), rs.getString(1), rs.getString(2));
			}
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	ArrayList<Article> getAllArticles() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from article");
			ArrayList<Article> myArticles = new ArrayList<Article>();
			while (rs.next()) {
				Blob content = rs.getBlob(4);
				int length = (int) content.length();

				Article a = new Article(rs.getInt(1), rs.getString(2), rs.getDate(3), getUser(rs.getString(5)),
						content.getBytes(1, length));
				myArticles.add(a);
			}
			return myArticles;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean addArticle(Article article) {
		try {

			String query = "INSERT INTO article (id, name, date, content, writer) values(?, ?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, article.id);
			preparedStatement.setString(2, article.name);
			preparedStatement.setDate(3, (Date) article.datePublished);
			preparedStatement.setBytes(4, article.content);
			preparedStatement.setString(5, article.Writer.userName);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addArticleCategory(Article article, Category category) {
		try {

			String query = "INSERT INTO article_categories (article_id, category_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, article.id);
			preparedStatement.setString(2, category.name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addArticleComment(Article article, Comment comment) {
		try {

			String query = "INSERT INTO article_comments (article_id, comment_id) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, article.id);
			preparedStatement.setInt(2, comment.id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addArticleFollower(Article article, User follower) {
		try {

			String query = "INSERT INTO article_followers (article_id, follower_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, article.id);
			preparedStatement.setString(2, follower.name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addArticleNotification(User user, ArticleNotification articleNotification) {
		try {

			String query = "INSERT INTO article_notification (id, content, state, to_user, article_id) values(?, ?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, articleNotification.id);
			preparedStatement.setString(2, articleNotification.message);
			if(articleNotification.IsSeen())
				preparedStatement.setBoolean(3, true);
			else
				preparedStatement.setBoolean(3, false);
			preparedStatement.setString(4, user.userName);
			preparedStatement.setInt(5, articleNotification.article.id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBook(Book book) {
		try {

			String query = "INSERT INTO book (id, Author, Name, Date, Link, Description) values(?, ?, ?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, book.author);
			preparedStatement.setString(3, book.name);
			preparedStatement.setDate(4, (Date) book.datePublished);
			preparedStatement.setString(5, book.hyperlink);
			preparedStatement.setString(6, book.description);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBookCategory(Book book, Category category) {
		try {

			String query = "INSERT INTO book_categories (book_id, category_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, category.name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBookComment(Book book, Comment comment) {
		try {

			String query = "INSERT INTO book_comments (book_id, comment_id) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setInt(2, comment.id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBookFollower(Book book, User user) {
		try {

			String query = "INSERT INTO book_followers (book_id, user_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, user.userName);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBookNotification(User user, BookNotfication bookNotification) {
		try {

			String query = "INSERT INTO book_notification (id, content, state, to_user, book_id) values(?, ?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, bookNotification.id);
			preparedStatement.setString(2, bookNotification.message);
			if(bookNotification.IsSeen())
				preparedStatement.setBoolean(3, true);
			else
				preparedStatement.setBoolean(3, false);
			preparedStatement.setString(4, user.userName);
			preparedStatement.setInt(5, bookNotification.book.id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addBookReader(User user, Book book) {
		try {

			String query = "INSERT INTO book_readers (book_id, user_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, user.userName);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addCategory(Category category) {
		try {

			String query = "INSERT INTO category (name) values(?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, category.name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addComment(Comment comment) {
		try {

			String query = "INSERT INTO comment (id, content, writer) values(?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, comment.id);
			preparedStatement.setString(2, comment.content);
			preparedStatement.setString(3, comment.user.userName);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addReply(Reply reply) {
		try {

			String query = "INSERT INTO comment (id, content, parent_id writer) values(?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, reply.id);
			preparedStatement.setString(2, reply.content);
			preparedStatement.setInt(3, reply.parent.id);
			preparedStatement.setString(4, reply.user.userName);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
