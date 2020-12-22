package query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Manages database queries.
 * @author lbrandon
 */
public class DatabaseQueries {

	/**
	 * Query the database for given webpage using given connection.
	 * @param connection to use
	 * @param webpage to query for
	 */
	public static void readFromDatabase(Connection connection, String webpage) {
		
		try {
			
			PreparedStatement preparedStatement = null;
			
			//if webpage is null (not provided), query comments table for all records
			if (webpage == null) {
				preparedStatement 
					= connection.prepareStatement("SELECT * FROM comments");
			//if webpage is provided, filter query based on given webpage
			} else {
				preparedStatement 
					= connection.prepareStatement("SELECT * FROM comments WHERE webpage = ?");
				preparedStatement.setString(1, webpage);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			DatabaseQueries.printResultSet(resultSet);
			
			resultSet.close();
			preparedStatement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Query database using given connection
	 * @param connection to use
	 */
	public static void readFromDatabase(Connection connection) {
		//call overloaded method readFromDatabase with null webpage argument
		DatabaseQueries.readFromDatabase(connection, null);
	}
	
	/**
	 * Inserts the given attributes to a record in the database using the given connection.
	 * @param connection for db
	 * @param my_user for review
	 * @param email for user
	 * @param webpage for review
	 * @param summary of review
	 * @param comments for review
	 * @return number of records inserted into the db
	 */
	public static int writeToDatabase(Connection connection, String my_user, String email,
			String webpage, String summary, String comments) {
		
		int ret = 0;
		
		//create prepared statement to insert variables
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO comments VALUES (default, ?, ?, ?, ?, ?, ?)");
			
			//set parameter values via index, starting at 1
			preparedStatement.setString(1, my_user);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, webpage);
			
			//dynamically create date via Date object
			long millis = System.currentTimeMillis();
			preparedStatement.setDate(4, new java.sql.Date(millis));
			
			preparedStatement.setString(5, summary);
			preparedStatement.setString(6, comments);
			
			//execute SQL and get return value (number of inserted rows)
			ret = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Prints given result set.
	 * @param resultSet to print
	 */
	public static void printResultSet(ResultSet resultSet) {
		
		//loop through each row (record) in the resultset
		try {
			while (resultSet.next()) {
				
				//get the column values by column name
				String user = resultSet.getString("my_user");
				String email = resultSet.getString("email");
				String website = resultSet.getString("webpage");
				String summary = resultSet.getString("summary");
				Date date = resultSet.getDate("datum");
				String comments = resultSet.getString("comments");
				
				System.out.println("User: " + user);
				System.out.println("Email: " + email);
				System.out.println("Website: " + website);
				System.out.println("Summary: " + summary);
				System.out.println("Date: " + date);
				System.out.println("Comments: " + comments);
				System.out.println("________");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
