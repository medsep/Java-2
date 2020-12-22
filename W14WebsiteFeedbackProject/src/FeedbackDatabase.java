import java.sql.Connection;
import java.util.Scanner;

import connection.DatabaseConnection;
import query.DatabaseQueries;

/**
 * Query or insert records into a feedback database,
 * allowing users to review websites.
 * @author lbrandon
 */
public class FeedbackDatabase {

	public static void main(String[] args) {
		
		//open connection to db
		Connection connection = DatabaseConnection.openDatabase();
		
		//create scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		String input = null;
		boolean usingDB = true;
		
		while (usingDB) {
			
			//ask user what they want to do
			System.out.println("What do you want to do?  'Query', 'Input', or 'Quit'?");
			input = scanner.nextLine().trim();
			
			//switch statement: just like if ... else if ... else
			//with multiple conditions
			switch (input.toLowerCase()) {
				
				//just like if
				case "query":
					
					System.out.println("Which website or 'all'?");
					input = scanner.nextLine().trim();
					
					if ("all".equals(input)) {
						//query for all webpages
						DatabaseQueries.readFromDatabase(connection);
					} else {
						//query for given webpage
						DatabaseQueries.readFromDatabase(connection, input);
					}
					
					//break out of switch
					break;
					
				//just like else if
				case "input":
					
					//prompt user for information to insert into database
					System.out.println("(Separated by a comma) enter your name, email, "
							+ "the webpage, a summary, and your comments: ");
					input = scanner.nextLine().trim();
					
					//parse input to extract individual attributes
					String[] info = input.split(",");
					
					//get each piece of information from the array
					String my_user = info[0].trim();
					String email = info[1].trim();
					String webpage = info[2].trim();
					String summary = info[3].trim();
					String comments = info[4].trim();
					
					//insert information into database
					DatabaseQueries.writeToDatabase(connection, my_user, email, webpage, summary, comments);
					
					//immediately read from database to confirm most recent insert
					DatabaseQueries.readFromDatabase(connection);
					
					//break from switch statement
					break;
					
				//just like else	
				default:
					
					//quit the program
					usingDB = false;
					
					//break out of switch
					break;
			}
			
			System.out.println();
		}
		
		//close scanner
		scanner.close();
		
		//close connection to db
		DatabaseConnection.closeDatabase(connection);

	}

}
