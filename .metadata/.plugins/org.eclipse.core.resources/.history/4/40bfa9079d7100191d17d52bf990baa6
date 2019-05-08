import java.sql.Date;
import java.util.ArrayList;

public class Publication 
{
	String Name;
	Publisher publisher;
	ArrayList<User>read_users;
	ArrayList<String>categories;
	Date Date_published;
	ArrayList<Review> Reviews;
	String Description;
	Addition_Strategy Publication_addition_Strategy;

	public Publication(String n ,Publisher p ,Date date ,ArrayList<String>categories,String desc)
	{
		Name=n;
		publisher=p;
		read_users=new ArrayList<User>();
		categories=new ArrayList<String>();
		Date_published=date;
		Reviews=new ArrayList<Review>();
		Description=desc;
		
	}
	public void AddUser(User u)
	{
		read_users.add(u);
	}
	public void AddReview(Review r)
	{
		Reviews.add(r);
	}
	public void setAddition_strategy(Addition_Strategy a)
	{
		
	}



}
