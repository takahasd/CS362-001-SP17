package edu.osu.cs362;


import org.junit.Test;
import java.util.Random;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
	long randomseed = 10;
	Random random = new Random(randomseed);
	GregorianCalendar greg = new GregorianCalendar(); 
	Appt appt;
	CalDay calday = new CalDay(greg);
	int startHour;
	int startMinute;
	int startDay;
	int startMonth;
	int startYear;
	String title;
	String description;	 
	for(int i = 0;i < 200;i++)
	{
		startHour = ValuesGenerator.getRandomIntBetween(random,-12,48);
		startMinute = ValuesGenerator.getRandomIntBetween(random,-30,90);
		startDay = ValuesGenerator.getRandomIntBetween(random,-15,45);
		startMonth = ValuesGenerator.getRandomIntBetween(random,-6,18);
		startYear = ValuesGenerator.getRandomIntBetween(random,0,3000);
		title = ValuesGenerator.getString(random);
		description = ValuesGenerator.getString(random);
		appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
		calday.addAppt(appt);	 
	 }
	}


	
}
