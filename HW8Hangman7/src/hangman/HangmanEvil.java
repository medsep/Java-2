package hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The harder version Extends the traditional game Extends Hangman
 * 
 * @author meh
 *
 */
public class HangmanEvil extends Hangman {

	// map to store word families
	Map<String, List<String>> wordFamily = new HashMap<String, List<String>>();

	/**
	 * Constructor of the evil version of the Hangman game.
	 * 
	 * @param wordList
	 */
	public HangmanEvil(List<String> wordList) {
		super(wordList);
	}

	/**
	 * Updates the word after each user guess.
	 */
	@Override
	protected void updateTheWord() {

		// reset word family
		wordFamily.clear();

		// get iterator object from list
		Iterator<String> it = this.wordList.iterator();

		// use the iterator while traversing the list
		while (it.hasNext()) {
			// get the word in the word list
			String word = it.next();

			// this is the mark to record whether we should skip this round
			boolean mark = false;

			// check if the word has the same length as original word, skip this iteration
			// if not
			if (word.length() != this.getTheWord().length()) {
				continue;
			}

			// this word should not contain any letter in incorrect guesses, skip this
			// iteration if not
			for (int i = 0; i < this.getIncorrectGuess().size(); i++) {
				if (word.contains(this.getIncorrectGuess().get(i).toString())) {
					mark = true;
				}
			}

			// this word should have the same correct guess position as before, skip this
			// iteration if not
			for (int i = 0; i < this.getTheWord().length(); i++) {
				// capture the letter at ith position of the word
				char letter = this.getTheWord().charAt(i);
				// if this is a visible position
				if (this.getCorrectGuess().contains(letter)) {
					if (word.charAt(i) != letter) {
						mark = true;
					}
					// if this is not a visible position
				} else {
					if (this.getCorrectGuess().contains(word.charAt(i))) {
						mark = true;
					}
				}
			}

			if (mark) {
				continue;
			}

			// find the pattern of the word
			String pattern = word.replaceAll("[^" + this.userResponse + "]", "_");

			if (!this.wordFamily.containsKey(pattern)) {
				// create new key if this pattern do not exist
				List<String> family = new ArrayList<String>();
				;
				family.add(word);
				this.wordFamily.put(pattern, family);

			} else {
				// add the word to the pattern key
				List<String> family = wordFamily.get(pattern);
				family.add(word);
				this.wordFamily.put(pattern, family);
			}
		}

		// initialize max length and corresponding word
		int maxLength = 0;
		String evilWord = "";

		// loop through the keys of word family
		for (String key : wordFamily.keySet()) {

			// update max length
			if (wordFamily.get(key).size() > maxLength) {
				maxLength = wordFamily.get(key).size();
				evilWord = wordFamily.get(key).get(0);
			}
		}

		// update the word
		this.setTheWord(evilWord);
	}

}