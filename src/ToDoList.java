/**
 * Provide a simple to-do application.
 
 * @author Loveina Mohan
 * @version 2018.10.01
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ToDoList 
{
	private ArrayList<Task> tasks;
	private HashMap<String,ArrayList<Task>> project;
	
	public ToDoList()
	{
		tasks = new ArrayList<>();
	}
	
	private static void printWelcome()
	{
		System.out.println();
        System.out.println("Welcome to my ToDoly!");
        System.out.println();
	}
	
	public void CurrentDateTime()
	{   
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    System.out.println("Today is :" + sdf.format(date)); 
		    System.out.println();
	}
	
	public void addTask() 
	{
	    ArrayList<String> tasks=new ArrayList<String>();  
	    System.out.println("Here are the following tasks to-do !!");
		tasks.add("Birthday plan");
		tasks.add("Meetings");
		tasks.add("Doctor appointment");
		tasks.add("spa");
		tasks.add("Gyming");
		tasks.add("Shopping");
		
		System.out.println(tasks);
	}
	
	public void sort() 
	{
		
	}
	
	public void editTask() 
	{
		
	}
	
	public void removeTask() 
	{
		
	}
	
	public void markTask() 
	{
		
	}
	
	public void showTask() 
	{
		
	}
	
	
	public static void main(String[] args) 
	{
		ToDoList tdl = new ToDoList();
		printWelcome();
		tdl.CurrentDateTime();
		tdl.addTask();
	}
}