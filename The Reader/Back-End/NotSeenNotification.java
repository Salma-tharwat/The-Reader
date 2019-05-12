import java.awt.SystemColor;

public class NotSeenNotification implements NotificationState {

	@Override
	public SystemColor getBackGroundColor() {
		return SystemColor.inactiveCaption;
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
