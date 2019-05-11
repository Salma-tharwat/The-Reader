
public class NotificationStateFactory {
	public static NotificationState getNotification(NotificationStateTypes type)
	{
		if(type == NotificationStateTypes.seen)
			return new SeenNotification();
		else if(type == NotificationStateTypes.notSeen)
			return new NotSeenNotification();
		else return null;
	}
}
