package hangman;

import java.util.List;

// static variable
/**
 * Represents the traditional hangman..
 */
public class HangmanTraditional extends Hangman {

	/**
	 * constructor for the tradition Hangman
	 * 
	 * @param wordList list of clean words
	 */
	public HangmanTraditional(List<String> wordList) {
		super(wordList);
	}

	/**
	 * update the word in each round (keep the same for this version)
	 */
	@Override
	public void updateTheWord() {

	}

}
