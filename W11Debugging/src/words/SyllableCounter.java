package words;

import java.util.Scanner;

/**
 * Count syllable in words of a sentence
 * 
 * @author meh
 *
 */

public class SyllableCounter {

	public static void main(String[] args) {

		System.out.println("Enter a sentence: ");

		// create scanner for user input

		Scanner in = new Scanner(System.in);

		String input;
		Word w;
		int syllables;

		// while there is a word to scan
		while (in.hasNext()) {

			// scan next token(word)
			input = in.next();

			// create instance of word class with user inputted word
			w = new Word(input);

			// count syllables in a word
			syllables = w.countSyllables();

			System.out.println("Syallables in " + w.getText() + ": " + syllables);
			// break out of while loop at period (end of sentence)
			if (input.endsWith("."))
				break;
		}

	}

}
