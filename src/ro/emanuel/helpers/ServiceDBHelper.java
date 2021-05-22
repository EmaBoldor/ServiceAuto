package ro.emanuel.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceDBHelper {

	private static Connection con;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (con == null || con.isClosed()) {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", connectionProps);
		}
		return con;

	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
