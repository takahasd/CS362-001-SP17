package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=0;
		 int startMinute=0;
		 int startDay=1;
		 int startMonth=1;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(0, appt.getStartHour());
		 assertEquals(0, appt.getStartMinute());
		 assertEquals(1, appt.getStartDay());
		 assertEquals(1, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	@Test
	public void test08() throws Throwable	{
		int startHour=23;
		int startMinute=59;
		int startDay=31;
		int startMonth=12;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party";
		Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertTrue(appt.getValid());
	}
		
	@Test
	public void test02() throws Throwable   {
		int startHour=25;
		int startMinute=61;
		int startDay=32;
		int startMonth=13;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertFalse(appt1.getValid())	;
	}
	@Test
	public void test09() throws Throwable	{
		Appt appt = new Appt(12,30,4,3,2017,"Event","My Event");
		appt.setStartHour(25);
		assertFalse(appt.getValid());
	}
	@Test
	public void test10() throws Throwable	{
		Appt appt = new Appt(12,30,4,3,2017,"Event","My Event");
		appt.setStartMinute(65);
		assertFalse(appt.getValid());
	}
	@Test
	public void test11() throws Throwable	{
		Appt appt = new Appt(12,30,4,3,2017,"Event","My Event");
		appt.setStartDay(32);
		assertFalse(appt.getValid());
	}
	@Test
	public void test12() throws Throwable	{
		Appt appt = new Appt(12,30,4,3,2017,"Event","My Event");
		appt.setStartMonth(32);
		assertFalse(appt.getValid());
	}
	@Test
	public void test03() throws Throwable	{
		int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		Appt appt2 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertEquals("	4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n",appt2.toString());
		startHour=11;
		appt2 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertEquals("	4/10/2017 at 11:30am ,Birthday Party, This is my birthday party.\n",appt2.toString());
		startHour=27;
		appt2 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(null,appt2.toString());
		
	}
	@Test
	public void test04() throws Throwable	{
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt3 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);	
		 appt3.setStartHour(1);
		 appt3.setStartMinute(1);
		 appt3.setStartDay(1);
		 appt3.setStartMonth(1);
		 appt3.setStartYear(1);
	 	 appt3.setTitle("Midterm");
		 appt3.setDescription("CS362 Midterm");
		 assertEquals(1,appt3.getStartHour());
		 assertEquals(1,appt3.getStartMinute());
		 assertEquals(1,appt3.getStartDay());
		 assertEquals(1,appt3.getStartMonth());
		 assertEquals(1,appt3.getStartYear());
		 assertEquals("Midterm",appt3.getTitle());
		 assertEquals("CS362 Midterm",appt3.getDescription());
		 assertTrue(appt3.getValid());
	}
	@Test
	public void test05() throws Throwable	{
		int startHour=12;
		int startMinute=30;
		int startDay=4;
		int startMonth=14;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt4= new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertFalse(appt4.getValid());
		startDay=34;
		startMonth=6;
		appt4= new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertFalse(appt4.getValid());
		startDay=12;
		startMinute=65;
		appt4= new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		assertFalse(appt4.getValid());
	}
	@Test
	public void test06() throws Throwable	{
		int startHour=12;
		int startMinute=30;
		int startDay=4;
		int startMonth=11;
		int startYear=2017;
		String title="Event";
		String description="This is an event.";
		Appt appt5 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		description=null;
		appt5.setDescription(description);
		assertEquals("",appt5.getDescription());
		assertTrue(appt5.getValid());
	}
	@Test
	public void test07() throws Throwable	{
		int startHour=12;
		int startMinute=30;
		int startDay=4;
		int startMonth=11;
		int startYear=2017;
		String title="Event";
		String description="This is an event.";
		Appt appt6 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		title=null;
		appt6.setTitle(title);
		assertEquals("",appt6.getTitle());
		assertEquals("This is an event.",appt6.getDescription());
	}
}
