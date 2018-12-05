import java.util.Calendar;

public class Helpers {
	
	public static String formatTime(Calendar calendar, Integer time) {
		return Integer.toString(calendar.get(time));
	}
    
    public static String getCurrentTime() {
    	Calendar calendar = Calendar.getInstance();
    	String currentHour = Helpers.formatTime(calendar, Calendar.HOUR_OF_DAY);
    	String currentMinute = Helpers.formatTime(calendar, Calendar.MINUTE);
    	String currentSecond = Helpers.formatTime(calendar, Calendar.SECOND);
    	return currentHour + ":" + currentMinute + ":" + currentSecond;
    }
    
    public static String formatMessage(String username, String message) {
    	String currentTime = Helpers.getCurrentTime();
    	return "[" + currentTime + "] <" + username + "> " + message; 
    }
    
    public static String formatMessage(String message) {
    	String currentTime = Helpers.getCurrentTime();
    	return "[" + currentTime + "] " + message; 
    }

}
