package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * utility class for reading particular types of files.
 * 
 * @author meh
 *
 */

public class MyFileReader {
	/**
	 * Sums teh numbers in file. If no numbers or errors retruns 0
	 * 
	 * @param filename
	 * @return sums
	 * @throws FileNotFoundException if file is not found
	 */

	public static double readFileGetTotalSum(String fileName) throws FileNotFoundException {
		// load and create file
		File file = new File(fileName);

		double sum = 0.0;

		// creates scanner
		Scanner scanner = new Scanner(file);

		// while scanner has another value
		while (scanner.hasNext()) {

			// if value is a double
			if (scanner.hasNextDouble()) {

				// get token (val) as a double and add to sum
				double numDouble = scanner.nextDouble();
				sum += numDouble;
				// if it is not a doubel skip it
			} else {
				scanner.next();
			}
		}
		// clsoe
		scanner.close();

		return sum;
	}

	/**
	 * Calculates sum of nums in each line
	 */

	public static ArrayList<Double> readFileGetLineSums(String fileName) {

		// create arraytlist for each line
		ArrayList<Double> lineSums = new ArrayList<Double>();

		// create file object
		File file = new File(fileName);

		// defile file and buffered readers
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				// split line into token of values based on white space using regex
				// to indicate 1 or more instances of white space
				String[] numStringArray = line.trim().split("\\s+");

				// set defualt sum for line
				double sum = 0.0;

				for (int i = 0; i < numStringArray.length; i++) {

					// get each value as a string
					String numString = numStringArray[i];
					// try parsing to double
					try {
						// cast to double
						double numDouble = Double.parseDouble(numString);

						// add to sum for line
						sum += numDouble;
					} catch (NumberFormatException e) {
						System.out.println("Cant parse and add value. " + e.getMessage());
					}
				}

				// add line to list of sums
				lineSums.add(sum);

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

		// create buuffer reader

		return lineSums;
	}

}
