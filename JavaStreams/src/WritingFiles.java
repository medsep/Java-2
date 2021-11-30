import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {

	public static void main(String[] args) throws IOException {
		// stream connectivity

		File f = new File("C:\\Users\\mehdi\\OneDrive\\Documents\\filewriting\\textFile.html");
		FileWriter fw = new FileWriter(f, false); // true appends, false overwrites
		BufferedWriter writer = new BufferedWriter(fw);
		/*
		 * for (int i = 0; i < 5; i++) { for (int j = 0; j < 4; j++) {
		 * 
		 * int num = (int) (Math.random() * 100); writer.write(num + ","); }
		 * writer.newLine(); }
		 * 
		 * /* writer.newLine(); writer.write("First Line"); writer.newLine();
		 * writer.write("Second Line"); writer.newLine(); writer.write("Third Line");
		 * writer.newLine(); writer.write("Fourth Line"); writer.newLine();
		 */

		// closing the stream

		writer.write("<html> <body> <title>Hello</title> <h1>Hello world!!!</h1></body> </html>");
		writer.close();

		System.out.println("File Created!!!");

	}

}
