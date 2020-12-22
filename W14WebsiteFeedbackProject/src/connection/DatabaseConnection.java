package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages database connection.
 * 
 * @author lbrandon
 */
public class DatabaseConnection {

	/**
	 * JDBC database connection String.
	 */
	private static String url = "jdbc:mysql://34.233.122.117:3306/feedback";

	// FOR DEMO PURPOSES ONLY
	// YOU SHOULD NEVER STORE HARD-CODED CREDENTIALS IN YOUR PROGRAM FILES
	// Instead, use environment variables,
	// encrypted configuration files,
	// or some other external authentication method.
	/**
	 * Database username.
	 */
	private static String username = "mehsep";

	/**
	 * Database password.
	 */
	private static String password = "M1449.e94";

	/**
	 * Opens a database connection
	 * 
	 * @return db connection
	 */
	public static Connection openDatabase() {

		Connection connection = null;

		try {
			// load the appropriate MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection to DB using MySQL driver
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/feedback?" + "user=mehsep&password=M1449.e94");

			// DriverManager.getConnection(DatabaseConnection.url,
			// DatabaseConnection.username,
			// DatabaseConnection.password);

			System.out.println("Database connection is open.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * Closes given db connection.
	 * 
	 * @param connection to close
	 */
	public static void closeDatabase(Connection connection) {
		try {
			connection.close();

			System.out.println("Database connection is closed. " + connection.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
