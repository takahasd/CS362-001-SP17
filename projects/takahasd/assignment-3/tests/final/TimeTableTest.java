package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(12,30,3,3,2017,"event","my event");
		Appt appt1 = new Appt(11,20,3,3,2017,"midterm","my midterm");
		appts.add(appt0);
		appts.add(appt1);
		GregorianCalendar cal0 = new GregorianCalendar(1,1,2017);
		GregorianCalendar cal1 = new GregorianCalendar(2,2,2017);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal0,cal1);
		assertNotEquals(calday,null);	 
	 }
	@Test
	public void test02() throws Throwable	{
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(27,71,3,3,2017,"event","my event");
		Appt appt1 = new Appt(28,70,3,3,2017,"midterm","my midterm");
		appts.add(appt0);
		appts.add(appt1);
		GregorianCalendar cal0 = new GregorianCalendar(1,1,2017);
		GregorianCalendar cal1 = new GregorianCalendar(2,2,2017);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal0,cal1);
		assertNotEquals(null,calday);
	}
	@Test
	public void test03() throws Throwable	{
		TimeTable time = new TimeTable();
		Appt appt0 = new Appt(12,20,3,3,2017,"event","my event");
		Appt appt1 = new Appt(11,20,3,3,2017,"midterm","my midterm");
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt0);
		appts.add(appt1);
		assertNotEquals(time.deleteAppt(appts,appt1),null);
	}
	@Test
	public void test04() throws Throwable	{
		TimeTable time = new TimeTable();
		Appt appt0 = null;
		LinkedList<Appt> appts = new LinkedList<Appt>();
		assertEquals(null,time.deleteAppt(appts,appt0));
	}
	@Test
	public void test05() throws Throwable	{
		TimeTable time = new TimeTable();
		Appt appt0 = new Appt(27,75,3,3,2017,"event","my event");
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt0);
		assertEquals(null,time.deleteAppt(appts,appt0));
	}
	@Test
	public void test06() throws Throwable	{
		TimeTable time = new TimeTable();
		Appt appt0 = new Appt(12,30,3,3,2017,"event","my event");
		Appt appt1 = new Appt(11,20,3,3,2017,"midterm","my midterm");
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt0);
		assertEquals(null,time.deleteAppt(appts,appt1));
	}
	@Test
	public void test07() throws Throwable	{
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		GregorianCalendar cal0 = new GregorianCalendar(1,1,2017);
		GregorianCalendar cal1 = new GregorianCalendar(2,2,2017);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal0,cal1);
		assertNotEquals(null,calday);
	}
	@Test
	public void test08() throws Throwable	{
		try{
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(12,30,3,3,2017,"event","my event");
		Appt appt1 = new Appt(11,20,3,3,2017,"midterm","my midterm");
		appts.add(appt0);
		appts.add(appt1);
		GregorianCalendar cal1 = new GregorianCalendar(2,2,2017);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal1,cal1);
		}catch(IllegalArgumentException ex){
		}
	}
	@Test
	public void test09() throws Throwable	{	
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(12,30,1,7,2016,"event","my event");
		appts.add(appt0);
		GregorianCalendar cal1 = new GregorianCalendar(2017,1,1);
		GregorianCalendar cal2 = new GregorianCalendar(2017,2,2);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal1,cal2);

	}
	@Test
	public void test10() throws Throwable	{	
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(12,30,1,1,2017,"event","my event");
		appts.add(appt0);
		GregorianCalendar cal1 = new GregorianCalendar(2017,1,1);
		GregorianCalendar cal2 = new GregorianCalendar(2017,2,2);
		CalDay calen = new CalDay(new GregorianCalendar(2017,2,1));
		LinkedList<CalDay> calday = time.getApptRange(appts,cal1,cal2);
		assertEquals(calday.getLast().toString(),calen.toString());
		calen = new CalDay(new GregorianCalendar(2017,1,1));
		calen.addAppt(appt0);
		assertEquals(calen.toString(),calday.getFirst().toString());

	}
	@Test
	public void test11() throws Throwable	{
		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt0 = new Appt(12,30,1,2,2017,"event","my event");
		appts.add(appt0);
		GregorianCalendar cal1 = new GregorianCalendar(2017,1,1);
		GregorianCalendar cal2 = new GregorianCalendar(2017,2,2);
		CalDay calen = new CalDay(new GregorianCalendar(2017,2,1));
		calen.addAppt(appt0);
		LinkedList<CalDay> calday = time.getApptRange(appts,cal1,cal2);
		assertEquals(calday.getLast().toString(),calen.toString());
	}
}
