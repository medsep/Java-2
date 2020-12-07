package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {

	/**
	 * Counts the number of guesses
	 */
	private int count;

	/**
	 * counts good guesses
	 */
	private int correctCount;

	/**
	 * Counts bad guesses
	 */
	private int mistakesCount;

	private boolean goodGuess;

	/**
	 * check game is finished or not
	 */
	private boolean isGameOver;

	public int getCount() {
		return count;
	}

	public int getCountMistakes() {
		return mistakesCount;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public Hangman() {
		this.count = 0;
		this.correctCount = 0;
		this.mistakesCount = 0;
		this.goodGuess = false;
		this.isGameOver = false;
	}

	/**
	 * Given a file with words, list them the words in an array
	 * 
	 * @param filename
	 * @return
	 */
	public static ArrayList<String> readWords(String filename) {

		// create file
		File file = new File(filename);

		// store each line in an array
		ArrayList<String> lines = new ArrayList<String>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					lines.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			// gets and prints file name
			System.out.println("Sorry, " + file.getName() + " not found.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// regardless of what happnes close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;
	}

	/**
	 * Returns words with the given criteria.
	 * 
	 * @param filename
	 * @return
	 */
	public static ArrayList<String> cleanWords(ArrayList<String> words) {

		ArrayList<String> newWords = new ArrayList<String>();

		for (String word : words) {
			Pattern p = Pattern.compile("[A-Z0-9.'\\s]+");
			Matcher m = p.matcher(word);

			if (m.find()) {
				continue;
			} else {
				newWords.add(word);
			}
		}
		return newWords;
	}

	/**
	 * Randomly select a word from the cleaned list.
	 * 
	 * @param filename
	 * @return
	 */
	public static String selectWord(String filename) {
		Random rand = new Random();

		ArrayList<String> choice = Hangman.readWords(filename);
		choice = Hangman.cleanWords(choice);

		int choiceSize = choice.size();
		int select = rand.nextInt(choiceSize);
		String word = choice.get(select);
		return word;
	}

	/**
	 * check game is over
	 * 
	 * @param word
	 * @return
	 */
	public boolean isGameOver(String word) {

		List<Character> chars = new ArrayList<>();

		for (char ch : word.toCharArray()) {
			chars.add(ch);
		}

		Set<Character> set = new HashSet<Character>(chars);

		if (this.count <= 15) {
			if (this.count - this.mistakesCount == set.size()) {
				this.isGameOver = true;

				System.out.println("Congratulations! You won!");
			}
		} else {
			this.isGameOver = true;
			System.out.println("Sorry. You lose.");
		}

		return isGameOver;

	}

	/**
	 * Method to determine if the letter is in the word
	 * 
	 * @param word
	 * @param letter
	 * @return
	 */

	public boolean correctGuess(String word, String letter) {
		if (word.contains(letter)) {
			goodGuess = true;
		} else {
			goodGuess = false;
		}
		return goodGuess;
	}

	/**
	 * Prints the current guesses
	 * 
	 * @param word
	 * @param letter
	 */
	public void print(String word, String letter) {
		count += 1;
		if (this.correctGuess(word, letter)) {
			int i = word.indexOf(letter);
			while (i >= 0) {
				HangmanGame.current.set(i, letter + " ");
				i = word.indexOf(letter, i + 1);
			}
		} else {
			HangmanGame.incorrectList.add(letter);
			System.out.println("Incorrect guesses: " + HangmanGame.incorrectList);
			mistakesCount += 1;
		}
		for (String j : HangmanGame.current) {
			System.out.print(j);
		}
		System.out.println();
		System.out.println();

	}
}
