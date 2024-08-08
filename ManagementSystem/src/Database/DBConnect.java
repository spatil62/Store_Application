package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

// Code database URL
//	static final String DB_URL = "jdbc:mysql://www.papademas.net:3307/510labs?autoReconnect=true&useSSL=false";
// Database credentials
//	static final String USER = "fp510", PASS = "510";
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/ManagementSystem";
	static final String USER = "root", PASS = "";

	public Connection connect() throws SQLException {
		System.out.println("Connecting...");
		return DriverManager.getConnection(DB_URL, USER, PASS);

	}
}