import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.MessageFormat;
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
	ArrayList<AbstractComment> comments;
	ArrayList<Notification> notifications;

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

		users = getAllUsers();
		articles = getAllArticles();
		books = getAllBooks();
		categories = getAllCategories();
		comments = getAllComments();
		notifications = getAllNotifications();
		getArticleCategories();
		getArticleComments();
		getArticleFollowers();
		getBookCategories();
		getBookComments();
		getBookFollowers();
		getBookReaders();
		getUserCategories();
		getUserFollowers();
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

	public Book getBook(int id) {
		for (Book book : books) {
			if (book.id == id)
				return book;
		}
		return null;
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

	User getUser(String userName) {
		for (User user : users) {
			if (user.userName.equals(userName))
				return user;
		}
		return null;
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
				User user = getUser(rs.getString(5));
				user.createdArticles.add(a);
				myArticles.add(a);
			}
			return myArticles;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Category getCategory(String name) {
		for (Category category : categories) {
			//System.out.println(category.name);
			if (category.name.equals(name))
				return category;
		}
		return null;
	}

	public Article getArticle(int id) {
		for (Article article : articles) {
			if (article.id == id)
				return article;
		}
		return null;
	}

	public AbstractComment getComment(int id) {
		for (AbstractComment comment : comments) {
			if (comment.id == id)
				return comment;
		}
		return null;
	}

	private ArrayList<AbstractComment> getAllComments() {
		try {
			ArrayList<AbstractComment> comments = new ArrayList<AbstractComment>();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from comment");
			while (rs.next()) {
				boolean reply;
				int id = rs.getInt(1);
				String content = rs.getString(2);
				int parent_id = rs.getInt(3);
				reply = rs.wasNull();
				String writer = rs.getString(4);
				User user = getUser(writer);
				if (!reply)
					comments.add(new Comment(id, user, content));
			}
			rs = stmt.executeQuery("select * from comment");
			while (rs.next()) {
				boolean reply;
				int id = rs.getInt(1);
				String content = rs.getString(2);
				int parent_id = rs.getInt(3);
				reply = rs.wasNull();
				String writer = rs.getString(4);
				User user = getUser(writer);
				if (reply)
					comments.add(new Reply(id, user, content, getComment(parent_id)));
			}
			return comments;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private ArrayList<Notification> getAllNotifications() {
		try {
			ArrayList<Notification> notifications = new ArrayList<Notification>();
			getArticleNotifications(notifications);
			getBookNotifications(notifications);
			getUserNotifications(notifications);
			return notifications;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private void getArticleNotifications(ArrayList<Notification> notifications) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from article_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				String content = rs.getString(2);
				boolean state = rs.getBoolean(3);
				NotificationState notificationState;
				if (state)
					notificationState = new SeenNotification();
				else
					notificationState = new NotSeenNotification();
				String userName = rs.getString(4);
				User user = getUser(userName);
				int articleId = rs.getInt(5);
				Article article = getArticle(articleId);
				ArticleNotification articleNotification = new ArticleNotification(content, notificationState, article);
				articleNotification.id = id;
				notifications.add(articleNotification);
				user.notifications.add(articleNotification);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void getBookNotifications(ArrayList<Notification> notifications) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				String content = rs.getString(2);
				boolean state = rs.getBoolean(3);
				NotificationState notificationState;
				if (state)
					notificationState = new SeenNotification();
				else
					notificationState = new NotSeenNotification();
				String userName = rs.getString(4);
				User user = getUser(userName);
				int bookId = rs.getInt(5);
				Book book = getBook(bookId);
				BookNotfication bookNotfication = new BookNotfication(content, notificationState, book);
				bookNotfication.id = id;
				notifications.add(bookNotfication);
				user.notifications.add(bookNotfication);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void getUserNotifications(ArrayList<Notification> notifications) {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				String content = rs.getString(2);
				boolean state = rs.getBoolean(3);
				NotificationState notificationState;
				if (state)
					notificationState = new SeenNotification();
				else
					notificationState = new NotSeenNotification();
				String userName = rs.getString(4);
				User user = getUser(userName);
				String redirectUserName = rs.getString(5);
				User redirectUser = getUser(redirectUserName);
				UserNotification userNotification = new UserNotification(content, notificationState, redirectUser);
				notifications.add(userNotification);
				user.notifications.add(userNotification);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void getArticleCategories() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from article_categories");
			while(rs.next()) {
				int articleId = rs.getInt(1);
				String categoryName = rs.getString(2);
				Article article = getArticle(articleId);
				Category category = getCategory(categoryName);
				article.categories.add(category);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void getArticleComments() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from article_comments");
			while(rs.next()) {
				int articleId = rs.getInt(1);
				int commentId = rs.getInt(2);
				Article article = getArticle(articleId);
				AbstractComment comment = getComment(commentId);
				article.comments.add((Comment)comment);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void getArticleFollowers() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from article_followers");
			while(rs.next()) {
				int articleId = rs.getInt(1);
				String userName = rs.getString(2);
				Article article = getArticle(articleId);
				User user = getUser(userName);
				article.followers.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getBookCategories() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_categories");
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String categoryName = rs.getString(2);
				Book book = getBook(bookId);
				Category category = getCategory(categoryName);
				book.categories.add(category);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getBookComments() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_comments");
			while(rs.next()) {
				int bookId = rs.getInt(1);
				int commentId = rs.getInt(2);
				Book book = getBook(bookId);
				AbstractComment comment = getComment(commentId);
				book.comments.add((Comment)comment);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getBookFollowers() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_followers");
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String userName = rs.getString(2);
				Book book = getBook(bookId);
				User user = getUser(userName);
				book.followers.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getBookReaders() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_readers");
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String userName = rs.getString(2);
				Book book = getBook(bookId);
				User user = getUser(userName);
				user.readBooks.add(book);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getUserCategories() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_categories");
			while(rs.next()) {
				String userName = rs.getString(1);
				String categoryName = rs.getString(2);
				User user = getUser(userName);
				Category category = getCategory(categoryName);
				user.interests.add(category);
				category.followers.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void getUserFollowers() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_followers");
			while(rs.next()) {
				String followedUserName = rs.getString(1);
				String followerUserName = rs.getString(2);
				User followed = getUser(followedUserName);
				User follower = getUser(followerUserName);
				followed.followers.add(follower);
			}
		} catch (Exception e) {
			System.out.println(e);
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
			
			articles.add(article);
			article.Writer.createdArticles.add(article);
			article.Writer.notifyFollowers(new ArticleNotification(MessageFormat.format("User {0} add article {1}", article.Writer.name, article.name), new NotSeenNotification(), article));
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
			
			article.categories.add(category);
			category.notifyFollowers(new ArticleNotification(MessageFormat.format("Article {0} added to category {1}", article.name, category.name), new NotSeenNotification(), article));
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean addArticleComment(Article article, Comment comment) {
		try {
			//TODO: the id should be sequence
			String query = "INSERT INTO article_comments (article_id, comment_id) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, article.id);
			preparedStatement.setInt(2, comment.id);
			preparedStatement.executeUpdate();
			
			article.comments.add(comment);
			article.notifyFollowers(new ArticleNotification(MessageFormat.format("User {0} commented on article {1}", comment.user.userName, article.name), new NotSeenNotification(), article));
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
			
			article.followers.add(follower);
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
			if (articleNotification.IsSeen())
				preparedStatement.setBoolean(3, true);
			else
				preparedStatement.setBoolean(3, false);
			preparedStatement.setString(4, user.userName);
			preparedStatement.setInt(5, articleNotification.article.id);
			preparedStatement.executeUpdate();
			
			notifications.add(articleNotification);
			user.notifications.add(articleNotification);
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
			
			books.add(book);
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
			
			book.categories.add(category);
			category.notifyFollowers(new BookNotfication(MessageFormat.format("New Book {0} added to categeory {1}", book.name, category.name), new NotSeenNotification(), book));
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
			
			book.comments.add(comment);
			book.notifyFollowers(new BookNotfication(MessageFormat.format("user {0} commented on book {1}", comment.user.userName, book.name), new NotSeenNotification(), book));
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
			
			book.followers.add(user);
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
			if (bookNotification.IsSeen())
				preparedStatement.setBoolean(3, true);
			else
				preparedStatement.setBoolean(3, false);
			preparedStatement.setString(4, user.userName);
			preparedStatement.setInt(5, bookNotification.book.id);
			preparedStatement.executeUpdate();
			
			notifications.add(bookNotification);
			user.notifications.add(bookNotification);
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
			
			user.readBooks.add(book);
			user.notifyFollowers(new BookNotfication(MessageFormat.format("user {0} read new book {1}", user.userName, book.name), new NotSeenNotification(), book));
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
			
			categories.add(category);
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
			
			comments.add(comment);
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
			
			comments.add(reply);
			AbstractComment mainComment = getComment(reply.parent.id);
			mainComment.replies.add(reply);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addUser(User user) {
		try {

			String query = "INSERT INTO user (user_name, password, name) values(?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user.userName);
			preparedStatement.setString(2, user.password);
			preparedStatement.setString(3, user.name);
			preparedStatement.executeUpdate();
			
			users.add(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addUserCategory(User user, Category category) {
		try {

			String query = "INSERT INTO user_categories (user_name, category_name) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user.userName);
			preparedStatement.setString(2, category.name);
			preparedStatement.executeUpdate();
			
			category.followers.add(user);
			user.interests.add(category);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addUserFollower(User followed, User follower) {
		try {

			String query = "INSERT INTO user_followers (followed_user, following_user) values(?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, followed.userName);
			preparedStatement.setString(2, follower.userName);
			preparedStatement.executeUpdate();
			
			followed.followers.add(follower);
			follower.notifications.add(new UserNotification(MessageFormat.format("User {0} followed you", follower.userName), new NotSeenNotification(), follower));
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean addUserNotification(User user, UserNotification userNotification) {
		try {

			String query = "INSERT INTO user_notification (id, content, state, to_user, redirect_user) values(?, ?, ?, ?, ?);";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userNotification.id);
			preparedStatement.setString(2, userNotification.message);
			if (userNotification.IsSeen())
				preparedStatement.setBoolean(3, true);
			else
				preparedStatement.setBoolean(3, false);
			preparedStatement.setString(4, user.userName);
			preparedStatement.setString(5, userNotification.user.userName);
			preparedStatement.executeUpdate();
			
			user.notifications.add(userNotification);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public int getNextBookId()
	{
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from book");
			while (rs.next()) {
				int id = rs.getInt(1);
				id++;
				return id;
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 1;
		}
	}
	
	public int getNextArticleId()
	{
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from artilce");
			while (rs.next()) {
				int id = rs.getInt(1);
				id++;
				return id;
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 1;
		}
	}
	
	public int getNextNotificationId()
	{
		int a = getMaxArticleNotification();
		int b = getMaxBookNotification();
		int c = getMaxUserNotification();
		
		int maxID = Math.max(a, Math.max(b, c));
		return maxID + 1;
	}

	private int getMaxBookNotification()
	{
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from book_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	private int getMaxArticleNotification()
	{
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from article_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	private int getMaxUserNotification()
	{
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from user_notification");
			while (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public boolean updateArticleNotification(ArticleNotification articleNotification) {
		try {

			String query = "update article_notification set content = ?, state = ?, article_id = ? where id = ? ;";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, articleNotification.message);
			if (articleNotification.IsSeen())
				preparedStatement.setBoolean(2, true);
			else
				preparedStatement.setBoolean(2, false);
			preparedStatement.setInt(3, articleNotification.article.id);
			preparedStatement.setInt(4, articleNotification.id);
			preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean updateBookNotification(BookNotfication bookNotification) {
		try {

			String query = "update book_notification set content = ?, state = ?, book_id = ? where id = ?;";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, bookNotification.message);
			if (bookNotification.IsSeen())
				preparedStatement.setBoolean(2, true);
			else
				preparedStatement.setBoolean(2, false);
			preparedStatement.setInt(3, bookNotification.book.id);
			preparedStatement.setInt(4, bookNotification.id);
			preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateUserNotification(UserNotification userNotification) {
		try {

			String query = "update user_notification set content = ?, state = ?, redirect_user = ? where id = ?;";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userNotification.message);
			if (userNotification.IsSeen())
				preparedStatement.setBoolean(2, true);
			else
				preparedStatement.setBoolean(2, false);
			preparedStatement.setString(3, userNotification.user.userName);
			preparedStatement.setInt(4, userNotification.id);
			preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
