import java.awt.SystemColor;

interface NotificationState{
	public SystemColor getBackGroundColor();
	public NotificationState clone();
	public boolean IsSeen();
}
