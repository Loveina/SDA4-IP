package Todolist;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *  This class is part of the "TODO list" application. 
 *  "TODO list" is a simple, text based application.It has many tasks, where each task performs its function.
 *  
 *  The Menu Operations also has various methods like add, update, show which is a part of high cohesion.
 *  It can implement task manager methods.
 *  
 *  Basically menu operations is a sub class of TODO list class.
 *  
 * @author  Loveina Mohan
 * @version 2018.10.12
 */
public class MenuOperations
{
	private Scanner scan;
	private TaskManager tm;
	
	/**
     * The constructor initializes the task manager class.
     */
	public MenuOperations(TaskManager tm) 
	{
		scan = new Scanner(System.in);
		this.tm = tm;
	}
	
	/**
     * It simply prints the welcome message as soon as you run the program.
     */
	public void printWelcome()
	{
		System.out.println();
        System.out.println("Welcome to my ToDoly!");
        System.out.println();
	}
	
	/**
     * It is used to return integer type after parsing it.
     */
	public int readMenuOperation() 
	{
		return Integer.parseInt(scan.nextLine());
	}
	
	/**
     * It uses scanner to read in console. The user gives the fields parameter.
     */
	public void addTask()
	{
		String title;
		LocalDate dueDate;
	    String project;
	    
	    System.out.println("Enter Title :");
	    title = scan.nextLine();
	     
	    System.out.println("Enter Due Date (YYYY-MM-DD) :");
	    dueDate = LocalDate.parse(scan.nextLine());
		
	    System.out.println("Enter Project :");
	    project = scan.nextLine();
	 
	    tm.addTask(title, dueDate, false, project);
	}
	
	/**
     * It is used to update task using the id. The scanner reads at the console and updates.
     */
	public void updateTask() 
	{
		int id;
	    System.out.println("Enter index to be updated :");
	    id = Integer.parseInt(scan.nextLine());
		String title;
	    System.out.println("Enter Title :");
	    title = scan.nextLine();
	    LocalDate dueDate;
	    System.out.println("Enter Due Date :");
	    dueDate = LocalDate.parse(scan.nextLine());
	    String project;
	    System.out.println("Enter Project :");
	    project = scan.nextLine();
	    
	    tm.updateTask(id, title, dueDate, project);
	}
	 
	/**
     * It is called from main class to choose an option.
     */
	public void printOptions() 
	{
		System.out.println("");
		System.out.println("Pick an option");
	    System.out.println("--------------");
	    System.out.println("(1) Show task List (by date)");
	    System.out.println("(2) Add New task ");
	    System.out.println("(3) Edit task ");
	    System.out.println("(4) Save and quit ");
	}
	
	/**
     * It is called from main class of edit method to choose an option.
     */
	public void printSubOptions()
	{
		System.out.println("CHOOSE AN OPTION");
	    System.out.println("***************");
	    System.out.println("(1) Update any task");
	    System.out.println("(2) Mark as done ");
	    System.out.println("(3) Remove task ");
	}
	
	/**
     * It is used to call two methods from task manager class.
     */
	public void showTaskList() 
	{
		tm.sortTasks();
		tm.printTasks();
	}
	
	/**
     * It is used to choose options when called from main class.
     * It calls the method from task manager class.
     */
	public void editTask()
	{
		boolean notFinished = true;
			while(notFinished) 
			{
				printSubOptions();
				int choice = readMenuOperation();
					
					switch (choice) 
					{
					case 1:
						updateTask();
						notFinished = false;
						break;
					case 2:tm.markAsDoneTask();
						notFinished = false;
						break;
					case 3:
						tm.removeTask();
						notFinished = false;
						break;
					default:
					}
			 }
	 }
}
