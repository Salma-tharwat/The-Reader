import java.util.Date;

public class Book extends Publication {
	String hyperlink;
	String author;
	String description;

	public Book(int id, String name, Date datePublished, String Author, String hyperlink, String description) {
		super(id, name, datePublished);
		this.author = Author;
		this.description = description;
		this.hyperlink = hyperlink;
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
