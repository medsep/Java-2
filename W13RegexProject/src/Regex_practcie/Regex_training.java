package Regex_practcie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_training {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";

		String regex = ".*http://.*";

		boolean matches = Pattern.matches(regex, text);

		System.out.println("matches = " + matches);

		String text1 = "This is the text which is to be searched " + "for occurrences of the word 'is'.";

		String regex1 = "is";

		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(text1);

		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
		}

	}

}
