import java.sql.Date;
import java.util.ArrayList;

public class Article extends Publication {
	byte[] content;
	User writer;

	public Article(int id, String name, Date date, User writer, byte[] file) {
		super(id, name, date);
		content = file;
		this.writer = writer;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void notifyFollowers(Notification notification) {
		for(User follower : followers) 
			follower.notify(notification);
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean addFollower(User user) {
		Database db = Database.getInstance();
		return db.addArticleFollower(this, user);
	}

}
