
public class TimeMain {
	private int hour;
	private int minute;
	private double second;

	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public double getSecond() {
		return this.second;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public static void printTime(Time t) {
		System.out.print(t.hour);
		System.out.print(":");
		System.out.println(t.minute);
		System.out.print(":");
		System.out.println(t.second);
	}

	public static void printTime1(Time t) {
		System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time = 360;
		printTime(Time);
	}

}
