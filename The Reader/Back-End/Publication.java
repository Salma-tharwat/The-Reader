import java.util.ArrayList;
import java.util.Date;

public abstract class Publication {
	int id;
	protected String name;
	Date datePublished;
	protected ArrayList<User> followers;
	ArrayList<Comment> comments;
	ArrayList<Category> categories;

	public Publication(int id, String name, Date datePublished) {
		this.id = id;
		this.name = name;
		this.datePublished = datePublished;
		followers = new ArrayList<User>();
		comments = new ArrayList<Comment>();
		categories = new ArrayList<Category>();

	}

	public Publication() {
		// TODO Auto-generated constructor stub
	}

	// add new follower
	// true : follower added
	// false : follower already exist
	public boolean addFollower(User user) {
		if (followers.contains(user))
			return false;
		followers.add(user);
		return true;
	}

	// remove a follower
	// true : follower removed
	// false : follower doesn't exist
	public boolean removeFollower(User user) {
		return followers.remove(user);
	}

	// check if user is a follower
	public boolean isFollowing(User user) {
		return followers.contains(user);
	}

	protected abstract void notifyFollowers(Notification notification);

	// add new comment
	// true : comment added
	// false : comment already exist
	public boolean addReview(Comment comment) {
		if (comments.contains(comment))
			return false;
		comments.add(comment);
		return true;
	}

	// remove a follower
	// true : follower removed
	// false : follower doesn't exist
	public boolean removeReview(Comment comment) {
		return comments.remove(comment);
	}

	// add new category
	// true : category added
	// false : category already exist
	public boolean addCategory(Category category) {
		if (categories.contains(category))
			return false;
		categories.add(category);
		return true;
	}

	// remove a category
	// true : category removed
	// false : category doesn't exist
	public boolean removeCategory(Category category) {
		return categories.remove(category);
	}

	public abstract void Render();
}