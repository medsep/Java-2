
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides methods for parsing and answering questions about a given list of
 * strings.
 */
public class RegexQuestions {

	private ArrayList<String> lines;

	public RegexQuestions(ArrayList<String> lines) {
		this.lines = lines;
	}

	/**
	 * Given an array of tokens, prints their values.
	 * 
	 * @param arr of tokens
	 */
	public void printTokens(String[] arr) {
		for (String s : arr) {
			System.out.print("token: ");
			System.out.print(s + " " + '\n');
		}
		System.out.println("");
	}

	/**
	 * Returns boolean based on whether the string at the given line number starts
	 * with the given String.
	 * 
	 * @param lineNum
	 * @param str
	 * @return boolean value
	 */
	public boolean lineStartsWithString(int lineNum, String startStr) {
		// TODO
		// Do not use Java built-in String function(s), try to solve it with regex.
		String line = lines.get(lineNum);
		String regex = " ^ " + startStr;
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(line);

		// cant use m.match()
		return m.find();
	}

	/**
	 * Parses the line at the given line number into tokens based on the given input
	 * String.
	 * 
	 * @param lineNum
	 * @param regex
	 * @return String array of tokens
	 */
	public String[] parseLine(int lineNum, String regex) {
		// TODO

		String line = lines.get(lineNum);
		String[] tokens = line.split(regex);
		return tokens;

	}

	/**
	 * Removes all whitespace in a line at the given line number.
	 * 
	 * @param lineNum
	 * @return updated String
	 */
	public String removeWhitespace(int lineNum) {
		// TODO

		String line = lines.get(lineNum);
		// to remove just whitespace do this
		// return line.replaceAll(regex " ", replacement "");
		return line.replaceAll("\\s+", "");

	}

	/**
	 * Returns boolean based on whether the line at the given line number contains
	 * an integer or not.
	 * 
	 * @param lineNum
	 * @return boolean value
	 */
	public boolean lineContainsInteger(int lineNum) {
		// TODO
		String line = lines.get(lineNum);
		// create regex pattern
		String regex = "-*\\d+-*";

		// macth the pattern
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(line);
		return m.find();
	}

}
