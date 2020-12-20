package ProcessingFiles.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		// for (int i = 0; i < 3; i++) {
		// Scanner input = new Scanner(System.in);
		// System.out.println("Enter some text: ");
		// String enteredText = input.nextLine();
		// System.out.println("You entered: " + enteredText);
		// }

		String line;
		File file = new File("myfile.txt");
		Scanner input;
		try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				line = input.nextLine();
				System.out.println(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
			e.printStackTrace();
		}

		MyFileUtils myFileUtil = new MyFileUtils();
		try {
			System.out.println(myFileUtil.subtract10FromLargerNumber(9));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
