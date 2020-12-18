
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		MyFileReader fr = new MyFileReader("moon_and_sixpence.txt");

		ArrayList<String> lines = fr.getCleanContent();

		RegexQuestions rq = new RegexQuestions(lines);

		int lineNum = 0; // change this number to see different results!

		// print the original string
		System.out.println("Original string: " + lines.get(lineNum) + '\n');

		// print whether the line starts with given word
		System.out.println("Does this line start with the given word?:");
		System.out.println(rq.lineStartsWithString(lineNum, "Rose"));
		System.out.println("\n");

		// parse line on string; print the tokens
		String[] parseLine = rq.parseLine(lineNum, "is");
		rq.printTokens(parseLine);

		// print the line without whitespace
		System.out.println("String without whitespace: " + rq.removeWhitespace(lineNum));

		// print whether the line contains an integer
		System.out.println("Does this line contain an integer? " + rq.lineContainsInteger(lineNum) + '\n');

	}

}
