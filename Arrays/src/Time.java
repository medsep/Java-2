
public class Time {
	int hour;
	int minute;
	double second;

	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}

	Time time = new Time();

	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

}
