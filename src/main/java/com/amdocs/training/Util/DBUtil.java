package com.amdocs.training.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection =null;
	private DBUtil()
	{

	}
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/amdocs_project";
		String user = "root";
		String password = "aaradhya12";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(url, user, password);
			}
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
