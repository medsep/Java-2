package words;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a word with functionality for counting syllables
 * 
 * @author meh
 *
 */
public class Word {

	/**
	 * clean text for word
	 * 
	 * @param s
	 */
	private String text;

	// constructor

	public Word(String s) {

		// trim beginning of word
		int i = 0;
		while (i < s.length() && !Character.isLetter(s.charAt(i))) {
			i++;
		}

		// trim end of the word
		int j = s.length() - 1;
		while (j > 1 && !Character.isLetter(s.charAt(j))) {
			j--;
		}

		// gets a substring of given s based on i and j
		// stores it as text for word
		// e.g. 123hello321 will be stored as hello
		this.text = s.substring(i, j + 1);
	}

	/**
	 * count syllables bases count based on location of vowels in the word
	 * 
	 * @return
	 */
	public int countSyllables() {

		// set inital count
		int count = 0;

		// get index of last character in the word
		int end = this.text.length() - 1;

		// if no chars consider 0 syllables
		if (end < 0) {
			return 0;
		}

		// 'e' end of word doesn't count as begining of syllable
		char ch = this.text.charAt(end);
		if (ch == 'e' || ch == 'E') {
			end--;
		}

		// set flag for being inside a syllable
		boolean insideSyllable = false;

		// iterate over char in word and look for vowels
		for (int i = 0; i <= end; i++) {
			// get each character
			ch = this.text.charAt(i);

			// determine if a word is a vowel
			// create a character class using regular expression
			String vowelRegex = "[aeiouAEIOU]";

			// create pattern to match with character
			Pattern p = Pattern.compile(vowelRegex);

			// find macthes in char (casted on a String)
			Matcher m = p.matcher(ch + "");

			// if it is a vowel, enter syllable
			if (m.matches()) {
				if (!insideSyllable) {
					count++;
					insideSyllable = true;
				}
			} else {
				// reset flag back to false
				insideSyllable = false;

			}
		}
		/// every word has at least 1 syllable
		if (count == 0) {
			count = 1;
		}
		return count;
	}

	// get word text
	public String getText() {
		return this.text;
	}

}
