// https://java.keicode.com/lang/datetime-calendar.php
// javac -encoding UTF-8 DateTest1.java
import java.util.Calendar;
import java.util.TimeZone;

public class DateTest1 {
	public static void main(String[] args){
		Calendar c = Calendar.getInstance();
		// Los Angeles
		displayTime(c);		
		// Japan
		TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
		c.setTimeZone(tz);
		displayTime(c);
	}
	
	protected static void displayTime(Calendar c){
		System.out.println(c.getTimeZone().getDisplayName());
		System.out.println(
			c.get(Calendar.YEAR) 
			+ "_" + (c.get(Calendar.MONTH) + 1)
			+ "_" + c.get(Calendar.DAY_OF_MONTH)
			+ "_" + c.get(Calendar.HOUR_OF_DAY)
			+ "_" + c.get(Calendar.MINUTE)
			+ "_" + c.get(Calendar.SECOND)
			);
	}
}
