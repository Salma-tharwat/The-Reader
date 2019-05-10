import java.sql.Date;
import java.util.ArrayList;

public class Book extends Publication{
	String Hyperlink;
   String Author;
   String Description;
	public Book(String n, java.util.Date d, ArrayList<abstractCategory> arrayList, String desc , String link , String Author) {
		super(n, d, arrayList);
		Hyperlink=link;
		Description=desc;
		this.Author=Author;
	categories.add(new SportsCategory("Sports"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void NotifyFollowers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		
	}

}
