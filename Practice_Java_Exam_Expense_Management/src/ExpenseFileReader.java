import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseFileReader {

	public static List<String> loadExpenses(String fileName) {
		// TODO Implement method
		// Hint: Read each line in the file
		// If the line only contains whitespace, ignore it

		ArrayList<String> expenseArrayList = new ArrayList<String>();
		// create file object
		File file = new File(fileName);
		// create file reader
		FileReader fileReader = null;
		// create buffer reader
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// trim whitespaces
				// line = line.trim();

				if (!line.isBlank()) {
					line.strip();
					expenseArrayList.add(line);
				} else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry " + file.getName() + " not found");
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return new ArrayList<String>(expenseArrayList);
		// return expenseArrayList;
	}

	/**
	 * Parses month and expense amount from given list of expenses (returned from
	 * loadExpenses). Each row has a month number, a delimiter, and an expense
	 * amount. Delimiters can include a comma (,), a colon (:), or multiple spaces
	 * (' ').
	 * 
	 * Stores expenses in list of maps, each one consisting of a month number and an
	 * expense amount. For example: [{1=57.38}, {5=5.06}, {10=456.99}, {5=3.99},
	 * ...] Where 1 is the month (for jan) and 57.38 is an expense for that month. 5
	 * is the month (for may) and 5.06 is an expense amount for that month. 3.99 is
	 * another expense amount for month 5.
	 * 
	 * @param list of expenses to parse
	 * @return map of monthly expenses
	 */
	public static List<Map<Integer, Double>> parseExpenses(List<String> expenseList) {
		// TODO Implement method
		// Hint: Iterate over each line and split on the delimiters
		// Then get the month number and expense amount
		ArrayList<Map<Integer, Double>> monthlyExpense = new ArrayList<Map<Integer, Double>>();
		for (String item : expenseList) {
			String[] itemArray = item.split("[,:\\s]+");

			int monthInt = Integer.parseInt(itemArray[0]);
			Double expenseDouble = Double.parseDouble(itemArray[1]);
			HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
			hashMap.put(monthInt, expenseDouble);
			monthlyExpense.add(hashMap);
		}
		System.out.println(monthlyExpense);
		// return monthlyExpense;
		return new ArrayList<Map<Integer, Double>>(monthlyExpense);
	}
}
