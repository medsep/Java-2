
/**
 * Name : Mehdi Sepahvand,
Penn ID: 15228700,
Statement of work: Work is completely my own. The only resources used
 were lecture codes, and Java help library.
"""
 */

import java.util.ArrayList;
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
 * Conroller class. Runs the games.
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
		ArrayList<String> words = HangmanDictionary.getWords(filename);

		// loop while the player wants to pay again
		while (again == false) {

			// instantiate HangmanTraditional
			Hangman hangman = new HangmanTraditional(words);
			// Hangman hangman = new HangmanTraditional(finalWords);

			// choose randomly between the traditional version and evil version
			Random rand = new Random();
			int mode = rand.nextInt(2);
			if (mode == 1) {
				hangman = new HangmanEvil(words);
				// hangman = new HangmanEvil(finalWords);
			}

			// TO DELETE
			// System.out.println("Game version: " + hangman.getGameMode());
			// System.out.println(hangman.getSameLengthGroup());

			// print the initialized word
			hangman.print();

			// keep count of player's guesses
			int guessesCount = 0;

			// keep record of player's wrong guesses
			List<Character> wrongGuesses = new ArrayList<Character>();

			// keep record of all the player's guesses both right and wrong
			List<Character> allGuesses = new ArrayList<Character>();

			// while the conditions to end the game are not met, continue to take user input
			while (!hangman.isGameOver()) {

				System.out.println("Please enter a letter \n");
				System.out.println("Guess count: " + guessesCount);
				// scan user input
				if (scanner.hasNext()) {
					letter = scanner.next().toLowerCase();
					letterChar = letter.charAt(0);
				}

				// if the input is not a letter, ask the player to enter again
				while (!Character.isLetter(letterChar)) {
					System.out.println("Please enter an alphabetic letter");

					letter = scanner.next().toLowerCase();
					letterChar = letter.charAt(0);
				}

				// if the player makes repeated guesses, send her a message and ask for another
				// input
				while (allGuesses.contains(letterChar)) {
					System.out.println("Already entered, please try another letter");
					letter = scanner.next().toLowerCase();
					letterChar = letter.charAt(0);
				}

				// record legal guesses
				allGuesses.add(letterChar);

				// if the guess is not successful
				// add the guess to the wrongGuesses list
				if (!hangman.letterGuessed(letterChar)) {
					wrongGuesses.add(letterChar);
				}

				// if there are wrong guesses, print them out
				if (wrongGuesses.size() != 0) {
					System.out.println("Wrong Guesses: " + wrongGuesses);
				}

				// print the state of the word
				System.out.println();
				hangman.print();

				// increment the guesses' count
				guessesCount += 1;
			}

			// print final results
			if (guessesCount < 18) {
				System.out.println("Congrats you won!");
			} else {
				System.out.println("Sorry you lost!");
			}
			System.out.println("You played " + hangman.getGameMode() + "\n" + "Your total guess count was:  "
					+ guessesCount + "\n");

			System.out.println("Play again? (Y/N)");
			String reply = scanner.next();
			while (reply.charAt(0) != 'n' && reply.charAt(0) != 'N' && reply.charAt(0) != 'y'
					&& reply.charAt(0) != 'Y') {
				System.out.println("Please enter y/n");
				reply = scanner.nextLine();
			}
			if (reply.charAt(0) == 'n' || reply.charAt(0) == 'N') {
				again = true;
				System.out.println("Goodbye!");

			}
		}
		scanner.close();
	}

	// Instructions.
	public static void Instructions() {
		System.out.println("Welcome to Hangman.\n" + "This game has two versions: traditional and evil.\n"
				+ "In the traditional version of the game, the computer has to stick to the original word as the user guesses;\n"
				+ "In the evil version, the computer keeps changing the word in order to make the user’s task harder.\n"
				+ "You won't be told which version you are playing until the game is over.\n" + "");
	}
}