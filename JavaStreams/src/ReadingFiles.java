import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFiles {

	public static void main(String[] args) throws IOException {
		// stream connectivity

		File f = new File("C:\\Users\\mehdi\\OneDrive\\Documents\\filewriting\\textFile.txt");
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);

		// System.out.println(reader.readLine());
		// System.out.println(reader.readLine());

		String Line = null;

		while ((Line = reader.readLine()) != null) {

			System.out.println(Line);
		}

		reader.close();
	}

}
