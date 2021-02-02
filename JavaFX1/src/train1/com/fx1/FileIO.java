package train1.com.fx1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

	public static void main(String[] args) {

		try {
			File file = new File("fileName1.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter pw = new PrintWriter(file);
			pw.println("This is a new one.");
			pw.println(10000000);
			pw.close();
			System.out.println("Completed.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
