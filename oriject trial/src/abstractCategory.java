import java.util.ArrayList;

public abstract class abstractCategory
{
  String Name;
  ArrayList<User>Followers;
  public abstractCategory(String name)
  {
	  Name=name;
  }
   public abstract void NotifyFollowers();
   public void GetInstance()
   {
	   
   }
}
