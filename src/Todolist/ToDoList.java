package Todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  This class is the main class of the "TODO list" application. 
 *  "TODO list" is a simple, text based application.It has many tasks, where each task performs its function.
 *  
 *  It basically displays 4 options , where you have to pick one at a time and follow the steps.
 * 
 *  To start with, need to run the program from the main class using the Run button.
 * 
 *  This main class creates object of its class and it has a start method.
 * 
 * @author  Loveina Mohan
 * @version 2018.10.12
 */

public class ToDoList 
{
	MenuOperations mo;
	TaskManager tm;
	
	/**
     * It initializes and creates a file text.
     */
	public ToDoList()
	{
		tm = new TaskManager();
		mo = new MenuOperations(tm); 
		tm.setFile("datastore.txt");
	}
	
	/**
     * This method displays the current time and date of the present day.
     */
	public void CurrentDateTime()
	{   
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		System.out.println("Today is :" + sdf.format(date)); 
		System.out.println();
	}
	
	/**
     * This method starts the program.
     * This method is called from the main method and displays in the console.
     * 
     */
	public void start() 
	{
		mo.printWelcome();
		CurrentDateTime();
		
		outLoop:
		while(true) 
		{
			mo.printOptions();
			int choice = mo.readMenuOperation();
				
			switch (choice) 
			{
			case 1:
				mo.showTaskList();
				break;
			case 2:
				mo.addTask();
				break;
			case 3:
				mo.editTask();
				break;
			case 4:
				tm.saveTasksToFile();
				System.out.println();
				System.out.println("hejdå ! Vi ses snart !:)");
				break outLoop;
			default:	
			}
		 }
	}

	/**
     * It is the main method of this entire program.
     */
	public static void main(String[] args)
	{
		ToDoList tdl = new ToDoList();
		tdl.start();
	}	
}
