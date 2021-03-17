package com.db;

import java.sql.Connection; //CTRL+SHIFT+O
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() {
		Connection con = null;
		String URL = "jdbc:mysql://localhost:3306/c02";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "Meghashyam@73");
			
			System.out.println("Connection Established...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

}
