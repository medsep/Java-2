import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintTime {
	public static void printTime(int hour, int minute) {
		System.out.print(hour);
		System.out.print(":");
		System.out.println(minute);
	}

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		int hour = 11;
		int minute = 59;
		printTime(hour, minute);
	}
}
