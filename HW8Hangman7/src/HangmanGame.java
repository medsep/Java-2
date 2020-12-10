
/**
 * Name : Mehdi Sepahvand,
Penn ID: 15228700,
Statement of work: Work is completely my own. The only resources used
 were lecture codes, and Java help library.
"""
 */

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dictionary.HangmanDictionary;
import hangman.Hangman;
import hangman.HangmanEvil;
import hangman.HangmanTraditional;
//import hangman.HangmanEvil;
//import hangman.HangmanTraditional;
//import hangman.HangmanEvil;
//import hangman.HangmanTraditional;

/**
 * Conroller class. Runs the game.
 * 
 * @author meh
 *
 */

public class HangmanGame {

	static boolean again = false;

	/**
	 * main method set up the game set up the scanner and take user input read the
	 * file and build word dictionary implement the game
	 * 
	 * @param args the main function
	 */
	public static void main(String[] args) {

		// print instructions
		Instructions();

		// set up the scanner
		Scanner scanner = new Scanner(System.in);

		// set up a string variable to store letters
		String letter = "";

		// set up a character variable to store letters
		char letterChar = ' ';

		// read and clean the file and return the ArrayList with words from the file
		String filename = "words.txt";
		// ArrayList<String> words = HangmanDictionary.getWords(filename);

		HangmanDictionary myReader = new HangmanDictionary(filename);

		// store all the words in a list
		List<String> wordList = myReader.readFileIn();

		// randomly choose game version
		String versionOfGame = HangmanGame.randomChooseVersion();
		// create Hangman instance
		Hangman hangman;
		if (versionOfGame.equals("traditional hangman")) {
			hangman = new HangmanTraditional(wordList);
		} else {
			hangman = new HangmanEvil(wordList);
		}

		// provide initial information
		System.out.println("Welcome to Hangman!\n");
		System.out.println();

		// While the game is not over
		while (hangman.isGameOver() == false) {

			// print correct game status
			hangman.printHangman();

			// have the user take a turn.
			hangman.haveUserTakeTurn();

		}

		// print final game information
		System.out.println("Congratulations, you have guessed the correct word \"" + hangman.getTheWord() + "\"!");
		System.out.println();
		System.out.println("Mede: " + versionOfGame);
		System.out.println("Guess count: " + (hangman.getCorrectGuess().size() + hangman.getIncorrectGuess().size()));
		System.out.println("Mistakes count: " + hangman.getIncorrectGuess().size());

		// close scanner
		Hangman.scanner.close();

	}

	/**
	 * Determines which version of the game we're playing.
	 * 
	 * @return true for normal false for evil Hangman.
	 */
	public static String randomChooseVersion() {

		// Import random.
		Random random = new Random();
		// use the random boolean method in random to determine which version of the
		// game the computer is going to play.
		Boolean WhichVersion = random.nextBoolean();

		// Return which version of the game we're playing.
		if (WhichVersion) {
			return "traditional hangman";
		} else {
			return "evil hangman";
		}
	}

	// Instructions.
	public static void Instructions() {
		System.out.println("Welcome to Hangman.\n" + "This game has two versions: traditional and evil.\n"
				+ "In the traditional version of the game, the computer has to stick to the original word as the user guesses;\n"
				+ "In the evil version, the computer keeps changing the word in order to make the user’s task harder.\n"
				+ "You won't be told which version you are playing until the game is over.\n" + "");
	}
}