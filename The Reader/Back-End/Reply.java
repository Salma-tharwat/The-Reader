
public class Reply extends AbstractComment {
	AbstractComment parent;

	public Reply(User user, String content, AbstractComment parent) {
		super(user, content);
		this.parent = parent;
	}
	
	@Override
	public void Notify() {
		// TODO Auto-generated method stub

	}

}
