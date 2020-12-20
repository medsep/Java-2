package LearnJDBC.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://127.0.0.1:3306/employees_database";
		int rowsAffected = 0;
		try {
			// Establish Connection Object
			Connection conn = DriverManager.getConnection(url, "root", "password");

			// Create a statement object to send to the database
			Statement statement = conn.createStatement();

			// Execute the statement object
			// rowsAffected = statement.executeUpdate(
			// "insert into employees_tbl(id, name, dept, salary) values (900, 'Robert',
			// 'Sales', 4000);");
			// System.out.println("Execute insert statement - Rows Affected: " +
			// rowsAffected);

			rowsAffected = statement.executeUpdate("update employees_tbl set salary = 6000 where id = 600;");
			System.out.println("Execute update statement - Rows Affected: " + rowsAffected);

			ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
			// Process the result

			while (resultSet.next()) {
				System.out.println(resultSet.getString("name") + "'s monthly salary: " + resultSet.getInt("salary"));
			}

			// int salaryTotal = 0;
			// while (resultSet.next()) {
			// salaryTotal += resultSet.getInt("salary");
			// }
			// System.out.println("Total salary in the employees_tbl is: " + salaryTotal);

		} catch (SQLException e) {
			System.out.println("Error while/update insertion");
		}

	}

}
