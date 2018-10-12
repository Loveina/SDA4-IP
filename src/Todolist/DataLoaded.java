package Todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  This class is part of the "TODO list" application. 
 *  "TODO list" is a simple, text based application.It has many tasks, where each task performs its function.
 *  
 * 	The Data Loaded basically uses streams to lad and save tasks in the text based file.
 * 	It uses the array list of task where lading is done using file name.
 * It saves the tasks in the file.
 *  
 * @author  Loveina Mohan
 * @version 2018.10.12
 */
public class DataLoaded 
{
	/**
     * The load file method uses streams where it reads the dats to the file.
     * Exceptions are used to catch the exception the file throws.
     */
	public ArrayList<Task> loadFile(String filename)
	{
		String name = filename;
		
		BufferedReader br = null;
		ArrayList<Task> taskList = new ArrayList<Task>();
		try {
			br = new BufferedReader(new FileReader(name));
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				String[] parts = line.split(",", 5);
				System.out.println(line);
				String id = parts[0];
				String title = parts[1];
				String dueDate = parts[2];
				String status = parts[3];
				String project = parts[4];
					
				Task t = new Task(Integer.parseInt(id), title, LocalDate.parse(dueDate), Boolean.parseBoolean(status),project);
				taskList.add(t);
			}
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		} 
		finally 
		{
			if (br != null) 
			{
				try 
				{
					br.close();
				} 
				catch (IOException e) {}
			}
		}
		return taskList;
	}

	/**
     * The save in file method is used to save the tasks in the file.
     * It writes the data in the file.
     */
	public boolean saveInfile(ArrayList<Task> tasks, String filename)
	{
		PrintWriter pw = null;
		
		String row = "";
		try {
			File file = new File(filename);
			pw = new PrintWriter(file);

			// It continues to append data t
			for (Task t : tasks) 
			{
				row  = String.format("%s,%s,%s,%s,%s", t.getId(),t.getTitle(),t.getDueDate(),t.getStatus(),t.getProject());
				System.out.println(row);
				pw.println(row);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		} 
		finally 
		{
			if (pw != null) 
			{
				pw.close();
			}
		}
		return true;
	}
}

