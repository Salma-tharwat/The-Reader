import java.sql.Date;
import java.util.ArrayList;

public class Article extends Publication {
	ArrayList<String> Content = new ArrayList<String>();
	User Writer;

	public Article(String n, Date date, ArrayList<abstractCategory> categories, ArrayList<String> file) {
		super(n, date, categories);
		Content = file;
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
