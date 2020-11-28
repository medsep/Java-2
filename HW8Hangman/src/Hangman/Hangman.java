package Hangman;

public class Hangman {

	/**
	 * Counts the number of guesses
	 */
	private int count;

	/**
	 * counts good guesses
	 */
	private int countCorrect;

	/**
	 * Counts bad guesses
	 */
	private int countMistakes;

	/**
	 * check game is finished or not
	 */
	private boolean isGameOver;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountCorrect() {
		return countCorrect;
	}

	public void setCountCorrect(int countCorrect) {
		this.countCorrect = countCorrect;
	}

	public int getCountMistakes() {
		return countMistakes;
	}

	public void setCountMistakes(int countMistakes) {
		this.countMistakes = countMistakes;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

}
