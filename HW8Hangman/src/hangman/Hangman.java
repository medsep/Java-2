package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountCorrect() {
		return getCountCorrect();
	}

	public void setCountCorrect(int countCorrect) {
		this.correctCount = countCorrect;
	}

	public int getCountMistakes() {
		return getCountMistakes();
	}

	public void setCountMistakes(int countMistakes) {
		this.correctCount = countMistakes;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public Hangman() {
		int count = 0;
		int correctCount = 0;
		int mistakesCount = 0;
		boolean goodGuess = false;
		boolean isGameOver = false;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// regardless of what happnes close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
	public static ArrayList<String> cleanWords(ArrayList<String> filename) {

		ArrayList<String> words = new ArrayList<String>();

		for (String word : words) {
			Pattern p = Pattern.compile("[A-Z0-9.'\\s]+");
			Matcher m = p.matcher(word);

			if (m.find()) {
				continue;
			} else {
				words.add(word);
			}
		}
		return words;
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
	void print(String word, String letter) {
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
		System.out.println("/n");
	}
}
