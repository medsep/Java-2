package hangman;

import java.util.ArrayList;

public class HangmanTraditional extends Hangman {

	// static variable
	/**
	 * Represents the game mode.
	 */
	private static final String MODE = "traditional";

	// instance variables
	/**
	 * Randomly picked word inherited from superclass Hangman.
	 */
	String firstWord = super.getWord();

	/**
	 * This constructor initializes a traditional hangman game.
	 * 
	 * @param path of the txt file
	 */
	public TraditionalHangman(String path) {
		// initialize the game
		super(path);
	}

	// Methods
	/**
	 * This methods returns the type of current game.
	 * 
	 * @return "traditional"
	 */
	String getGameType() {
		return "traditional";
	}

	/**
	 * This method returns true when a character is a correct guess. This method
	 * also updates the correct array, known word and mistakes.
	 * 
	 * @param ch
	 * @return correct (true/false)
	 */
	public boolean isCorrect(String ch) {

		boolean correct = false;

		for (int i = 0; i < this.getWordLength(); i++) {
			if (ch.charAt(0) == this.word.charAt(i)) {
				// update correct array
				this.correct[i] = true;

				// update known word
				this.knownWord[i] = ch;

				correct = true;
			}
		}

		// update the mistakes
		if (correct == false)
			this.mistakes += 1;
		return correct;
	}

}

	/**
	 * Returns the information of the game mode.
	 */
	@Override
	public String getGameMode() {
		return HangmanTraditional.MODE;
	}

}