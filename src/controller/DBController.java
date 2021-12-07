package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {
	private Connection connection;
	static DBController instance;
	
	
	String DB_URL = "jdbc:mysql://localhost:3306/ensf480";
	String DB_USER = "ensf480";
	String DB_PASSWORD = "ensf480";
	
	
	private DBController() {
		String url = DB_URL;
		String user = DB_USER;
		String password = DB_PASSWORD;

		

		try {
			connection = DriverManager.getConnection(url, user, password);
//			executeFile("/init.sql");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static DBController getInstance() { 
		if (instance == null)
			instance = new DBController();
		return instance;
	}
	
	
	public int execute(String query, Object... args) {
		try {
			PreparedStatement s = connection.prepareStatement(query);

			for (int i = 0; i < args.length; i++) {
				s.setObject(i + 1, args[i]);
			}

			try {
				s.execute();
			} catch (SQLException e) {
				System.out.println("Exception happens when execute this query");
			}
			
			return s.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public ResultSet query(String query, Object... args) {
		try {
			PreparedStatement p = connection.prepareStatement(query);

			for (int i = 0; i < args.length; i++) {
				p.setObject(i + 1, args[i]);
			}

			ResultSet res = p.executeQuery();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
