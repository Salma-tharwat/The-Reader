
public class NotSeenNotification implements NotificationState {

	@Override
	public void getBackGroundColor() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public NotificationState clone() {
		return new NotSeenNotification();
	}

	@Override
	public boolean IsSeen() {
		return false;
	}
}
