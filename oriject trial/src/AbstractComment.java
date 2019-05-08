import java.util.ArrayList;

public abstract class AbstractComment 
{
   ArrayList<Comment>replies;
   String Content;
   User user;
   public void addReply(Reply r)
   {
	   
   }
   public abstract void Notify();
}
