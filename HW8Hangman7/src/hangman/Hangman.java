package hangman;

/**
 * This the main method that runs teh game.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Hangman {

	// Instance variables

	// Store all of the correct guesses.
	private List<Character> correctGuess = new ArrayList<>();

	// Store all of the correct guesses.
	private List<Character> incorrectGuess = new ArrayList<>();

	// The word that the computer chose from the word list as a string.
	private String theWord;

	// list to store all clean words
	protected List<String> wordList;

	// running update of user response for each round
	protected String userResponse;

	// create global scanner instance
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * Constructor for Hangman.
	 * 
	 * @param wordList
	 */
	public Hangman(List<String> wordList) {

		// initialize text word list
		this.wordList = wordList;
		// have the computer choose a word for the game.
		this.setTheWord(randomChooseWord());

	}

	/**
	 * This method is what the computer uses to choose the word that the player will
	 * have to guess.
	 * 
	 * @return a single word, as a string that the computer will use for the game.
	 */

	public String randomChooseWord() {

		// Initialize random.
		Random random = new Random();
		// Get the length of the word list.
		int lengthOfwordList = this.wordList.size();
		// choose a random integer within the range of the word list to index the word
		// that we want.
		int whichIndexOfwordList = random.nextInt(lengthOfwordList);
		// update the game word.
		return this.wordList.get(whichIndexOfwordList);

	}

	/**
	 * Has the user take a turn aka. guess a letter or the word. Updates the number
	 * of incorrect guesses the user has taken so far.
	 */

	public void haveUserTakeTurn() {

		while (true) {
			// get user input
			System.out.print("Please guess a letter: ");

			// capture user input
			this.userResponse = scanner.next().toLowerCase();

			// check user input
			this.updateTheWord();

			// convert string to char, take first char by default
			char userResponseChar = userResponse.charAt(0);
			if (!Character.isLetter(userResponseChar)) {
				System.out.println("Please enter an alphabetic letter");
				break;
			}

			// if the input is not a letter, ask the player to enter again

			// check whether the user's guess is repeated
			if (!this.getCorrectGuess().contains(userResponseChar)
					&& !this.getIncorrectGuess().contains(userResponseChar)) {
				// update guess history
				if (this.getTheWord().contains(userResponse)) {
					this.getCorrectGuess().add(userResponseChar);
				} else {
					this.getIncorrectGuess().add(userResponseChar);
				}
				// break the loop if guess is not repeated
				break;
			} else {
				System.out.println("The letter \"" + userResponseChar + "\" has already been guessed, "
						+ "please try another letter.");
				System.out.println();
			}
		}
	}

	/**
	 * This method print out the current game status and list of wrong guess
	 */

	public void printHangman() {

		// print current game status
		for (int i = 0; i < this.getTheWord().length(); i++) {
			// display character that has been guessed
			if (this.getCorrectGuess().contains(this.getTheWord().charAt(i))) {
				System.out.print(" " + this.getTheWord().charAt(i) + " ");
			}
			// display character that hasn't been guessed
			else {
				System.out.print(" _ ");
			}
		}
		System.out.println();

		// print wrong guess list
		System.out.println("Incorrect Guess: " + this.getIncorrectGuess());
		System.out.println("Guess count: " + (this.getCorrectGuess().size() + this.getIncorrectGuess().size()));
		System.out.println();

	}

	/**
	 * Decide whether the game is over.
	 * 
	 * @return true if game is over otherwise false.
	 */

	public boolean isGameOver() {

		// iterate through each character in the word
		for (int i = 0; i < this.getTheWord().length(); i++) {
			// return false if at least one character has not been guessed
			if (!this.getCorrectGuess().contains(this.getTheWord().charAt(i))) {
				return false;
			}
		}
		// return true if all characters have been guessed correctly
		return true;
	}

	/**
	 * This method updates the word in each round
	 */
	protected abstract void updateTheWord();

	/**
	 * If guess is correct
	 * 
	 * @return correct guesses
	 */
	public List<Character> getCorrectGuess() {
		return correctGuess;
	}

	/**
	 * setter for correct guesses
	 * 
	 * @param correct guess
	 */

	public void setCorrectGuess(List<Character> correctGuess) {
		this.correctGuess = correctGuess;
	}

	/**
	 * Getter for words.
	 * 
	 * @return word
	 */
	public String getTheWord() {
		return theWord;
	}

	/**
	 * Setter for the words.
	 * 
	 * @param theWord
	 */
	public void setTheWord(String theWord) {
		this.theWord = theWord;
	}

	/***
	 * Getter for incorrect guesses.
	 * 
	 * @return incorrect guess
	 */
	public List<Character> getIncorrectGuess() {
		return incorrectGuess;
	}

	/**
	 * setter for incorrect guesses
	 * 
	 * @param incorrectGuess
	 */
	public void setIncorrectGuess(List<Character> incorrectGuess) {
		this.incorrectGuess = incorrectGuess;
	}

}
