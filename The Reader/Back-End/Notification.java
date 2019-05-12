import java.awt.SystemColor;

public abstract class Notification {
	int id;
	String message;
	NotificationState notificationState;
	
	public Notification(String message, NotificationState notificationState) {
		this.message = message;
		this.notificationState = notificationState;
	}
	
	public boolean IsSeen()
	{
		return this.notificationState.IsSeen();
	}
	
	public void setNotficationState(NotificationState notificationState)
	{
		this.notificationState = notificationState;
	}
	
	public SystemColor getBackGroundColor()
	{
		return notificationState.getBackGroundColor();
	}
	
	public abstract boolean AddNotification(User user);
	
	public abstract Notification clone();
	
	public abstract void onclick() ;

}
