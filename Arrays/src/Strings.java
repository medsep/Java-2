
public class Strings {

	public static String reverse(String s) {
		String r = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			r = r + s.charAt(i);
		}
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("the"));

		String fruit = "banana";
		char letter = fruit.charAt(0);
		System.out.println(letter);
		if (letter == 'b') {
			System.out.println('?');
		}

		System.out.print("Roman alphabet: ");
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);
		}
		System.out.println();

		System.out.print("Greek alphabet: ");
		for (int i = 913; i <= 937; i++) {
			System.out.print((char) i);
		}
		System.out.println();
		String name = "Alan Turing";
		String upperName = name.toUpperCase();
		System.out.println(name);
		String text = "Computer Science is fun!";
		text = text.replace("Computer Science", "CS");
		System.out.println(text);

		for (int i = 0; i < fruit.length(); i++) {
			char letter1 = fruit.charAt(i);
			System.out.println(letter1);
		}

		for (char letters : fruit.toCharArray()) {
			System.out.println(letters);
		}

		int index = fruit.indexOf('a', 2);
		System.out.println(index);

		String name1 = "Alan Turing";
		String name2 = "Ada Lovelace";
		if (name1.equals(name2)) {
			System.out.println("The names are the same.");
		}

		int diff = name1.compareTo(name2);
		if (diff == 0) {
			System.out.println("The names are the same.");
		} else if (diff < 0) {
			System.out.println("name1 comes before name2.");
		} else if (diff > 0) {
			System.out.println("name2 comes before name1.");
		}

		System.out.println(timeString(19, 22));

	}

	public static String timeString(int hour, int minute) {
		String ampm;
		if (hour < 12) {
			ampm = "AM";
			if (hour == 0) {
				hour = 12; // midnight
			}
		} else {
			ampm = "PM";
			hour = hour - 12;
		}
		return String.format("%02d:%02d %s", hour, minute, ampm);
	}

}
