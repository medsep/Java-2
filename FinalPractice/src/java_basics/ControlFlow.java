package java_basics;

public class ControlFlow {

	public static void main(String[] args) {
		boolean hungry = true;
		
		if(hungry) {
			System.out.println("I'm starving.");
			//sysout + (control+tab to auto-complete)
		}else {
			System.out.println("I'm not hungry.");
		}
		
		int hungerRating = 5;
		if(!(hungerRating < 6) ) {
			System.out.println("Not hungry");
		}else {
			System.out.println("I'm starving!");
		}
		
		int favouriteTemp = 75;
		int currentTemp = 60;
		String opinion;
		if(currentTemp < favouriteTemp - 30) {
			opinion = "It's pretty cold";
		}else if (currentTemp < favouriteTemp - 20) {
			opinion = "It's kinda cold";
		}else if (currentTemp > favouriteTemp + 10) {
			opinion = "It's hot";
		}else {
			opinion = "It's beautiful.";
		}
		System.out.println(opinion);
		
		int month = 6;
		String monthString;
		switch(month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		default:
			monthString = "Unkown Month";
		}
		System.out.println(monthString);
	}

}
