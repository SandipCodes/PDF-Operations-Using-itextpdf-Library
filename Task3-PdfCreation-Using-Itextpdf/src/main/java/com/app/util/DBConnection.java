package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	public static Connection getConnection() {

		 Connection con=null;
		 
		 
		 try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "root");
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return con;
	}//getConnection()
}//DBConnection
