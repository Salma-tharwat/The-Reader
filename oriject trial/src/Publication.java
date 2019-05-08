import java.sql.Date;
import java.util.ArrayList;

public abstract class Publication 
{
	String Name;
	ArrayList<User>followers;
	ArrayList<abstractCategory>categories;
	java.util.Date Date_published;
	ArrayList<Comment>Comments;
	
	

	public Publication(String n  ,java.util.Date d ,ArrayList<abstractCategory> arrayList)
	{
		Name=n;
		followers=new ArrayList<User>();
		categories=arrayList;
		Date_published=d;
		Comments=new ArrayList<Comment>();
		
		
	}
	public void AddUser(User u)
	{
		followers.add(u);
	}
	public void AddReview(Comment r)
	{
		Comments.add(r);
	}
	public void Remove_Follower(User u)
	{
		followers.remove(u);
	}
    public void isFollowing(User u)
    {
    	
    }
   public  abstract void NotifyFollowers();
   public abstract void Render();
}