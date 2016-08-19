package ufal.ic.rbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Abigail Musa Gindaus
 */
public class ConnectionFactory {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); //not mandatory
		return DriverManager.getConnection("jdbc:mysql://localhost/beginning?user=root&password=");
	}
}