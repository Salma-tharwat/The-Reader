import java.awt.SystemColor;

public class SeenNotification implements NotificationState {

	@Override
	public SystemColor getBackGroundColor() {
		// TODO Auto-generated method stub
		return SystemColor.activeCaption;
	}
	
	@Override
	public NotificationState clone() {
		return new SeenNotification();
	}

	@Override
	public boolean IsSeen() {
		return true;
	}
}
