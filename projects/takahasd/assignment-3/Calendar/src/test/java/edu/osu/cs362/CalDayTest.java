package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calendar = new CalDay(cal);
		assertTrue(calendar.isValid());
		 
		
	 }
	 @Test
	 public void test02() throws Throwable	{
		Appt appt0 = new Appt(12,30,3,3,2017,"Birthday Party","My birthday party");
		Appt appt1 = new Appt(12,25,3,3,2017,"Birthday Party","my birthday party");
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calendar = new CalDay(cal);
		calendar.addAppt(appt0);
		calendar.addAppt(appt1);
		assertEquals(appt0,calendar.getAppts().get(0));
	}
	@Test
	public void test08() throws Throwable	{
		Appt appt0 = new Appt(12,30,3,3,2017,"Birthday Party","My birthday party");
		Appt appt1 = new Appt(11,25,3,3,2017,"Birthday Party","my birthday party");
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calendar = new CalDay(cal);
		calendar.addAppt(appt0);
		calendar.addAppt(appt1);
		assertEquals(appt1,calendar.getAppts().get(0));
	}
	@Test
	public void test03() throws Throwable	{
		GregorianCalendar cal = new GregorianCalendar(0,0,0);
		CalDay calendar = new CalDay(cal);
		assertNotEquals(null,calendar.getAppts());
		Appt appt0 = new Appt(12,30,3,3,2017,"Party","My party");
		Appt appt1 = new Appt(11,0,3,3,2017,"Event","My event");
		calendar.addAppt(appt0);
		assertEquals(1,calendar.getSizeAppts());
		calendar.addAppt(appt1);
		String calen = calendar.toString();
		assertEquals(31,calendar.getDay());
		assertEquals(11,calendar.getMonth());
		assertEquals(2,calendar.getYear());
		assertEquals(calen,"\t --- 11/31/2 --- \n --- -------- Appointments ------------ --- \n\t3/3/2017 at 11:0am ,Event, My event\n \t3/3/2017 at 12:30pm ,Party, My party\n \n");
	}
	@Test
	public void test04() throws Throwable	{
		GregorianCalendar cal = new GregorianCalendar(0,0,0);
		CalDay calendar = new CalDay(cal);
		Iterator<?> iter  = calendar.iterator();
		assertFalse(iter.hasNext());
	}
	@Test
	public void test05() throws Throwable	{
		CalDay calendar = new CalDay();
		Iterator<?> iter = calendar.iterator();
		assertEquals(null,iter);
		assertEquals(calendar.toString(),"");
	}
	@Test
	public void test06() throws Throwable	{
		GregorianCalendar cal = new GregorianCalendar(0,0,0);
		CalDay calendar = new CalDay(cal);
		Appt appt0 = new Appt(27,67,44,44,2017,"event","my event");
		calendar.addAppt(appt0);
		assertEquals(0,calendar.getSizeAppts());
	}
	@Test
	public void test07() throws Throwable	{
		GregorianCalendar cal = new GregorianCalendar(0,0,0);
		CalDay calendar = new CalDay(cal);
		Appt appt0 = new Appt(12,30,3,3,2017,"Birthday Party","My Birthday party");
		Appt appt1 = new Appt(11,30,3,3,2017,"Event","My event");
		calendar.addAppt(appt1);
		calendar.addAppt(appt0);	
		assertEquals(appt1,calendar.getAppts().get(0));
	}
}
