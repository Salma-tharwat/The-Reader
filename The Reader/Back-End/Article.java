import java.util.Date;
import java.util.ArrayList;

public class Article extends Publication {
	ArrayList<Byte> content;
	User Writer;

	public Article(int id, String name, Date date, User writer, ArrayList<Byte> file) {
		super(id, name, date);
		content = file;
	}

	@Override
	protected void NotifyFollowers() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
	}

}
