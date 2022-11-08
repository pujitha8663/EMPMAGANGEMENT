package com.util;

import java.awt.Taskbar.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.Statement;

public class UtilConnections {
	public static Connection connection = null;
	public static Properties properties = null;
	
	
	static {
	
		try {
			properties = new Properties();
			properties.load(UtilConnections.class.getClassLoader().getResourceAsStream("DB.connections"));
		    Class.forName(properties.getProperty("Driver"));
			connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
	return connection;	
	
		
	}
	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   public static void close(ResultSet result,java.sql.Statement statement) {
	   
	   if(result!=null)
		try {
			result.close();
			statement.close();
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
	   public static void close(java.sql.Statement statement) {
		   try {
			statement.close();
			 connection.close();
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
	   public static void main(String[] args) {
		System.out.println(UtilConnections.getConnection());
	}
	 
}
