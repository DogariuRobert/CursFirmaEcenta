package database;
import java.sql.*;

public class DatabaseConnection {
	Connection conn = null;

	public Connection handleConnection() {
		@SuppressWarnings("unused")
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/unitbv";

		// Database credentials
		String USER = "root";
		String PASS = "admin";
		
		if (conn != null) {
			return conn;
		} else {
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			return conn;
		}
	}
}
