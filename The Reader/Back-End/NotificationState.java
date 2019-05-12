import java.awt.SystemColor;

public interface NotificationState {
	public SystemColor getBackGroundColor();
	public NotificationState clone();
	public boolean IsSeen();
}
