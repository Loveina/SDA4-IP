import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;


public class Task
{	
	private String title;
	private Date date;
	private boolean status;
	private HashMap<String, ArrayList<String>> project;

	
	public String getTitle() 
	{
		return title;
	}
	
	public Date getDateTime() 
	{
		return date;
	}
	
	public boolean getStatus() 
	{
		return status;
	}
}