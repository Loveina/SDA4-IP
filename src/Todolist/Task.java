package Todolist;

import java.time.LocalDate;

/**
 *  This class is part of the "TODO list" application. 
 *  "TODO list" is a simple, text based application.It has many tasks, where each task performs its function.
 *  
 *  The Task has the getter and setter methods for all the fields.
 *  It is also used to give the date using the CompareTo method.
 *  
 * @author  Loveina Mohan
 * @version 2018.10.12
 */
public class Task implements Comparable<Task>
{	
	private int id;
	private String title;
	private LocalDate dueDate;
	private boolean status;
    private String project;

    /**
     * The constructor initializes the fields of the class.
     */
	public Task(int id, String title, LocalDate dueDate, boolean status, String project)
	{
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.status = status;
		this.project = project;
	}
	
	/**
     * It checks the date and returns it.
     */
	public int compareTo(Task o)
	{
		int lastCmp = dueDate.compareTo(o.dueDate);
        return lastCmp;
    }
		 
	/**
     * It is used to get the id and return it.
     */
	public int getId() 
	{
		return id;
	}
	
	/**
     * It is used to set the title.
     */
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	/**
     * It is used to get the title and return it.
     */
	public String getTitle() 
	{
		return title;
	}
	
	/**
     * It is used to set the date.
     */
	public LocalDate setDueDate(LocalDate dueDate) 
	{
		return this.dueDate = dueDate;
	}
	
	/**
     * It is used to get the date and return it.
     */
	public LocalDate getDueDate() 
	{
		return dueDate;
	}
	
	/**
     * It is used to set the status.
     */
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	/**
     * It is used to get the status and return it.
     */
	public boolean getStatus() 
	{
		return status;
	}
	
	/**
     * It is used to set the project.
     */
	public void setProject(String project) 
	{
		this.project = project;
	}
	
	/**
     * It is used to get the project and return it.
     */
	public String getProject() 
	{
		return project;
	}
	
	/**
     * Constructs a string builder and appends the fields and returns it.
     */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append("- title: ");
		sb.append(title);
		sb.append("- Due Date: ");
		sb.append(dueDate);
		sb.append("- status: ");
		sb.append(status);
		sb.append("- project: ");
		sb.append(project);
	  return sb.toString();
	}
}