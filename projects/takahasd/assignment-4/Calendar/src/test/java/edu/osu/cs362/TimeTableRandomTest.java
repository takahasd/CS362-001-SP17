package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		long randomseed = 10;
		Random random = new Random(randomseed);
		TimeTable table = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt appt;
		int startHour;
		int startMinute;
		int startDay;
		int startMonth;
		int startYear;
		String title;
		String description;
		for(int i = 0;i < 200;i ++)
		{
			startHour = ValuesGenerator.getRandomIntBetween(random,-12,48);
			startMinute = ValuesGenerator.getRandomIntBetween(random,-30,90);
			startDay = ValuesGenerator.getRandomIntBetween(random,-15,45);
			startMonth = ValuesGenerator.getRandomIntBetween(random,-6,18);
			startYear = ValuesGenerator.getRandomIntBetween(random,0,3000);
			title = ValuesGenerator.getString(random);
			description = ValuesGenerator.getString(random);
			appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
			if(i%2 ==0)
			{
				appts.addLast(appt);
			}
			table.deleteAppt(appts,appt);
		}
		Appt appt1 = new Appt(12,30,2,2,2017,"h","h");
		LinkedList<Appt> appts1 = new LinkedList<Appt>();	 
		 table.deleteAppt(null,null);
		 table.deleteAppt(null,appt1);
		 table.deleteAppt(appts1,null);
		 
	 }


	
}
