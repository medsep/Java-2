/**
 * Name : Mehdi Sepahvand,
Penn ID: 15228700,
Statement of work: Work is completely my own. The only resources used
 were lecture codes, and Java help library.
"""
 */

package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import dictionary.HangmanDictionary;
import hangman.Hangman;
import hangman.HangmanEvil;

/**
 * Conroller class. Runs the games.
 * 
 * @author meh
 *
 */
public class HangmanGame {

	/**
	 * represent what the current word looks like
	 */
	public static ArrayList<String> current;

	/**
	 * display the list of incorrect guesses
	 */
	public static ArrayList<String> incorrectList;

	/**
	 * represent the filtered words to be chosen by evil computer after the user
	 * guessing
	 */
	public ArrayList<String> pool2;
	static boolean again = false;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// HangmanDictionary.readDictionary(fileName)();

		// File file = null;

		// Scanner sc = new Scanner(System.in);
		// direct to word package
		// String filename = "/src/dictionary/words.txt";
		// Scanner sc = new Scanner(filename);

		String filename = "words.txt";
		HangmanDictionary.readDictionary(filename);
		// check the file exists
		if (filename != null) {
			System.out.println("resource found at url= " + filename);
		}
		// print instructions
		Instructions();

		//

		while (again == false) {

			String word = Hangman.selectWord(filename);
			ArrayList<String> history = new ArrayList<String>();

			HangmanGame.current = new ArrayList<String>();
			for (int i = 0; i < word.length(); i++) {
				current.add("_ ");
			}
			// randomly select normal or easy mode (0,1)
			Random rand = new Random();
			int level = rand.nextInt(2);

			if (level == 0) {
				Hangman start = new Hangman();
				HangmanGame.incorrectList = new ArrayList<String>();

				while (start.isGameOver() == false) {
					while (true) {
						System.out.println("Guess a letter: ");
						System.out.println("Guess count: " + start.getCount());
						if (start.getCount() == 0) {
							for (String k : HangmanGame.current) {
								System.out.print(k);

							}

							System.out.println();
						}
						String input = scan.next();
						String convertInput = Character.toString(input.charAt(0));

						if (history.contains(convertInput)) {
							System.out.println("You already used this letter.");
						} else if (Character.isLetter(input.charAt(0)) && !history.contains(convertInput)) {
							history.add(convertInput);
							start.print(word, convertInput);
							break;
						}

					}

					start.isGameOver(word);
				}
				System.out.println("You played the normal version of hangman." + "\n" + "You had a total of "
						+ start.getCount() + " guesses.");
			}
			// to play the evil version
			if (level == 1) {
				HangmanGame hangGame = new HangmanGame();

				HangmanEvil hangEvil = new HangmanEvil();

				ArrayList<String> pool = hangEvil.newDictionary(filename);

				HangmanGame.incorrectList = new ArrayList<String>();

				while (hangEvil.isGameOver() == false) {
					while (true) {
						System.out.println("Guess a letter:");
						System.out.println("Guess count: " + hangEvil.getCount());
						if (hangEvil.getCount() == 0) {
							for (String element : HangmanGame.current) {
								System.out.print(element);

							}

							System.out.println();
						}
						String input = scan.next();

						String input1 = Character.toString(input.charAt(0));

						if (history.contains(input1)) {
							System.out.println("You already used this letter." + "\n" + "Try a new one!");
						} else if (Character.isLetter(input1.charAt(0)) && !history.contains(input1)) {
							history.add(input1);
							hangEvil.print(word, input1);

							break;
						}

						if (hangEvil.getCount() == 1) {
							HashMap<String, ArrayList<String>> family = hangEvil.buildDictionary(pool, input1);
							hangGame.pool2 = hangEvil.pickLargestFamily(family);
						}

						HashMap<String, ArrayList<String>> family = hangEvil.buildDictionary(hangGame.pool2, input1);
						hangGame.pool2 = hangEvil.pickLargestFamily(family);
					}
					hangEvil.isGameOver(word);
				}
				System.out.println(
						"You played the Evil Hangman." + "\n" + "Your total guess count was:  " + hangEvil.getCount());
			}
			playAgain();
		}
		// sc.close();

	}

	public static boolean levelSelector(int level) {
		Random rand = new Random();
		level = rand.nextInt(2);
		return true;
	}

	public static boolean playAgain() {

		boolean playAgain = true;
		while (playAgain == true) {
			System.out.println("Play again? (Y/N)");
			String reply = scan.next();
			if (reply.equals("n") || reply.equals("N")) {
				System.out.println("Thank you for playing.");
				again = true;
				playAgain = false;
			}
			if (reply.equals("y") || reply.contentEquals("Y")) {
				System.out.println("Lets play again.");
				playAgain = false;
			}

		}
		return playAgain;
		// scan.close();
	}

	// Instructions.
	public static void Instructions() {
		System.out.println("Welcome to Hangman.\n" + "This game has two versions: traditional and evil.\n"
				+ "In the traditional version of the game, the computer has to stick to the original word as the user guesses;\n"
				+ "In the evil version, the computer keeps changing the word in order to make the user’s task harder.\n"
				+ "You won't be told which version you are playing until the game is over.\n" + "");
	}

}
