package Todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  This class is part of the "TODO list" application. 
 *  "TODO list" is a simple, text based application.It has many tasks, where each task performs its function.
 *  
 *  The Task Manager has an array list of tasks. 
 *  The methods like add, sort, print, update, remove are implemented here. 
 *  Task manager basically manages the operations used to implement the program.
 *  
 * @author  Loveina Mohan
 * @version 2018.10.12
 */

public class TaskManager 
{
	private ArrayList<Task> tasks;
	private Scanner input;
	private int id;
	private String filename;
	
	/**
     * It initializes and checks the size of tasks.
     */
	public TaskManager() 
	{
		tasks = new ArrayList<Task>();
		input = new Scanner(System.in);
		this.id = tasks.size();
	}

	/**
     * It has four parameters which is added in tasks.
     */
	public int addTask(String title, LocalDate dueDate, boolean status, String project) 
	{
		this.id += 1;
		tasks.add(new Task(this.id, title, dueDate, status, project));
		return this.id;
	}

	/**
     * It sorts the task using Collections.
     */
	public void sortTasks() 
	{
		Collections.sort(tasks);
	}
	
	/**
     * It checks if tasks is empty.
     */
	public boolean isEmpty() 
	{
	 return tasks.isEmpty();
	}
	
	/**
     * It checks the size of the tasks.
     */
	public int size() 
	{
		return tasks.size();
	}

	/**
     * It prints the tasks using the foreach loop.
     * The index is also shown for each tasks.
     */
	public void printTasks() 
	{
		int count = 0;
		for (Task x : tasks) 
		{
			System.out.println("index #" + count + " " + x);
			count++;
		}
		System.out.println();
	}

	/**
     * It updates the tasks using an id.
     */
	public boolean updateTask(int id, String title, LocalDate dueDate, String project) 
	{
		if (id < 0 || id >= size()) 
		{
			return false;
		}
		Task t = tasks.get(id);
		t.setTitle(title);
		t.setDueDate(dueDate);
		t.setStatus(true);
		t.setProject(project);
		return true;
	}

	/**
     * It removes a particular task using the index of the task.
     */
	public void removeTask() 
	{
		try
		{
			if (this.isEmpty()) 
			{
				System.out.println("Nothing to remove, tasks list is empty");
			} 
			else 
			{
				System.out.println("Enter index of task to remove :");
				int index = input.nextInt();
				input.nextLine();
				tasks.remove(index);
			}
		} 
		catch (InputMismatchException ex) 
		{
			System.out.println("Please enter only numbers");
		} 
		catch (IndexOutOfBoundsException ex) 
		{
			System.out.println("Invalid index number");
		}
	}
	
	/**
     * The task that has to be marked as done is done here using the index.
     */
	public void markAsDoneTask() 
	{
		try 
		{
			System.out.println("Enter index of task to be marked as done :");
			int index = Integer.parseInt(input.nextLine());
			Task tt = tasks.get(index);
			tt.setStatus(true);
			tasks.set(index, tt);
		} 
		catch (Exception e)
		{
			System.out.println("Please enter only numbers :");
		}
	}

	/**
     * It sets the file using the filename.
     */
	public void setFile(String filename) 
	{
		this.filename = filename;
	}

	/**
     * It saves the tasks to the text based file.
     */
	public boolean saveTasksToFile(String filename) 
	{
		DataLoaded dl = new DataLoaded();
		if (dl.saveInfile(tasks, filename)) 
		{
			return true;
		}
		return false;
	}

	/**
     * It uses global filename in the constructor of Task manager.
     */
	public boolean saveTasksToFile()
	{
		return this.saveTasksToFile(this.filename);
	}

	/**
     * It loads the tasks to the text based file.
     */
	public boolean loadTasksFromFile(String filename) 
	{
		DataLoaded dl = new DataLoaded();
		this.tasks = dl.loadFile(filename);
		return false;
	}

	/**
     * It uses global filename in the constructor of Task manager.
     */
	public boolean loadTasksFromFile() 
	{
		return this.loadTasksFromFile(this.filename);
	}
}
