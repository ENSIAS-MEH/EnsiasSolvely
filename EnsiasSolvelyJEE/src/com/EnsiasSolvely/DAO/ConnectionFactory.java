package com.EnsiasSolvely.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	// Nos attributs pilaaa	
		private static ConnectionFactory instance = new ConnectionFactory();
		public static final String URL = "jdbc:mysql://localhost:3306/ensiassolvely?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		public static final String USER = "root";
		public static final String PASSWORD = "";
		public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		
	// notre constructeur 
	private ConnectionFactory() {
			try { Class.forName(DRIVER_CLASS);} catch (ClassNotFoundException e) { e.printStackTrace();}		
		                        }// fin du constructeur



	private Connection createConnection() {
			Connection connection = null;
			try { connection = DriverManager.getConnection(URL, USER, PASSWORD);} catch (SQLException e) { System.out.println("ERROR: Unable to Connect to Database.");}
			return connection;
		                                  }// fin de creation de connection


	public static Connection getConnection() {
			return instance.createConnection();
		                                     }// fin de getConnection
	
	
 

	}