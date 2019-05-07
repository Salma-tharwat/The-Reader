import java.sql.Date;
import java.util.ArrayList;

public class Book extends Publication{
	ArrayList<String>Hyperlinks=new ArrayList<String>();

	public Book(String n, Publisher p, Date date, ArrayList<String> categories, String desc , ArrayList<String>links) {
		super(n, p, date, categories, desc);
		Hyperlinks=links;
		// TODO Auto-generated constructor stub
	}

}
