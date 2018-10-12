package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Todolist.*;

public class TestTaskManager 
{
	TaskManager tm;
	
	@Before
	public void setUp() throws Exception 
	{
		tm = new TaskManager();	
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	@Test
	public void addTask()
	{
		assertTrue(tm.isEmpty());
		int id = tm.addTask("Hello", date("2018-01-02"), false, "Hi");
		assertEquals(1, id);
		
		assertFalse(tm.isEmpty());
		
		id = tm.addTask("Hello", date("2018-01-08"), false, "Hi");
		assertEquals(2, id);
	}
	
	@Test
	public void updateTask() 
	{
		//int id = tm.updateTask(int, "welcome", date("1921-02-21"), "bye");
		//assertEquals(id, 1);
	}
	
	
	private LocalDate date(String date) {
		return LocalDate.parse(date);
	}
}
