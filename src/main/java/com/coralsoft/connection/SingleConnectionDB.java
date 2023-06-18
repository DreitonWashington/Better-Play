package com.coralsoft.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDB {

	private static String banco = "jdbc:mysql://localhost:3306/better_play?autoReconnect=true";
	private static String user = "dev";
	private static String password = "205015";
	private static Connection connection = null;

	public static Connection getConnection() {
		return connection;
	}

	static {
		conectar();
	}

	public SingleConnectionDB() {
		conectar();
	}

	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(banco, user, password);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
