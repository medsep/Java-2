package hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// direct to word package
		String filename = "/com/dictionary/words.txt";
		// check the file exists
		if (filename != null) {
			System.out.println("resource found at url= " + filename);
		}
		// print instructions
		Instructions();

		//

		boolean again = false;
		while (again) {

			String word = Hangman.selectWord(filename);
			ArrayList<String> history = new ArrayList<String>();

			HangmanGame.current = new ArrayList<String>();
			for (int i = 0; i < word.length(); i++) {
				current.add("_ ");
			}
			// randomly select normal or easy mode (0,1)
			Random rand = new Random();
			int level = rand.nextInt() % 2;

			if (level == 0) {
				Hangman start = new Hangman();
				HangmanGame.incorrectList = new ArrayList<String>();

				while (start.isGameOver() == false) {
					while (true) {
						System.out.println("Guess a letter: ");

						if (start.getCount() == 0) {
							for (String k : HangmanGame.current) {
								System.out.println(k + "/n");
							}
						}
						String input = sc.next();
						String convertInput = Character.toString(input.charAt(0));

						if (history.contains(convertInput)) {
							System.out.println("You already used this letter.");
						} else if (Character.isLetter(input.charAt(0)) && !history.contains(convertInput)) {
							history.add(convertInput);
							break;
						}

					}

					start.isGameOver(word);
				}
				System.out.println("You played the normal version of hangman. \n" + "You had a total of "
						+ start.getCount() + "guesses.");
			}
			if (level == 1) {

			}

		}

	}

	// Instructions.
	public static void Instructions() {
		System.out.println("Hangman is a 2-player word-guessing game generally played by having one player "
				+ "think of a word and the other player trying to guess that word letter by letter.\n"
				+ "The computer will pick a random word from a dictionary. A row of underscores represent "
				+ "each letter of the word (e.g. �dog� would be shown to the user as _ _ _).\n"
				+ "You guess one letter at a time. Every correct letter that they guess is shown in its correct location(s).\n"
				+ "You have 15 chances to guess.\n" + "You are not allowed to guess a letter twice.\n"
				+ "This game has two versions: traditional and evil.\n"
				+ "In the traditional version of the game, the computer has to stick to the original word as the user guesses;\n"
				+ "In the evil version, the computer keeps changing the word in order to make the user�s task harder.\n"
				+ "You won't be told which version you are playing until the game is over.\n" + "");
	}

	public static void normalHangman() {

	}

	public static void evilHangman() {

	}
}