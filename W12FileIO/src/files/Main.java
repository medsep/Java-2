package files;

import java.io.FileNotFoundException;
import java.util.ArrayList;

//controller class`
public class Main {

	public static void main(String[] args) {
		// name of file to read
		String fileName = "text.txt";
		// define default sum value
		double sum = 0.0;

		// try to get the sum of nums in the file
		try {
			sum = MyFileReader.readFileGetTotalSum(fileName);
		} catch (FileNotFoundException e) {
			// prints error message and line(stack trace)
			e.printStackTrace();
		} finally {
			// prints of value of sum refardless of exception
			System.out.println("total sum: " + sum);
		}

		// get list of line sums
		ArrayList<Double> lineSums = MyFileReader.readFileGetLineSums(fileName);
		System.out.println("total line sum: " + lineSums);

		// write list of sums to new file
		MyFileWriter.writeFileLineSums("text_line_sums.txt", lineSums, false);
	}

}
