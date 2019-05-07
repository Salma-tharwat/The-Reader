import java.util.ArrayList;

public class Review 
{
	Publication Publication;
	String Description;
	 int Rate;
	 ArrayList<String> Comments;
	 public Review(Publication p , String d , int r) 
	 {
		 Publication=p;
		 Description=d;
		 Rate=r;
		 Comments=new ArrayList<String>();
	 }




}
