package com.carpool.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;

public class DBConnectionManager {

	Properties props = new Properties();
	Connection con = null;

	String CLASS_NAME = this.getClass().getName();
	Logger logger = Logger.getLogger(CLASS_NAME);

	public Connection getConnection() {
		
		logger.info("Entering " + CLASS_NAME);

		try {

			//String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
			//String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
			//String DB_NAME = System.getenv("OPENSHIFT_APP_NAME");
		//	String FORNAME_URL = "com.mysql.jdbc.Driver";
			//String URL = "jdbc:"+System.getenv("OPENSHIFT_MYSQL_DB_URL")+ DB_NAME;
			String URL = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") +  ":"  + System.getenv("OPENSHIFT_MYSQL_DB_PORT")+ "/testcar1";
			
			
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(URL , "adminE8jk35Q" , "SlfTnsCBesa_");
	       // con = DriverManager.getConnection("mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/","root","root");
			
			if (con != null) {
				logger.info("Connection created Successfully !");
				System.out.println("Connection created Successfully !");
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return con;
	}
	
	public Connection getConnectionRest(JsonNode dbConnectionDetails) {
		
		logger.info("Entering " + CLASS_NAME);

		try {

			Class.forName("org.postgresql.Driver");
			//"jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/udwzgumv","udwzgumv","ZvRQU0t6v7byKb7C2G5Cv94V8wO1nEGI"
	        //con = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/udwzgumv","udwzgumv","ZvRQU0t6v7byKb7C2G5Cv94V8wO1nEGI");
	       
	        String connectUrl = dbConnectionDetails.get("jdbcconnectionurl").asText().trim();
	        String username  = dbConnectionDetails.get("username").asText().trim();
	        String password = dbConnectionDetails.get("password").asText().trim();
	        
	       /* if(connectUrl.trim().equalsIgnoreCase(connectUrl_copy)) {
	        	System.out.println("url matches");
	        }
	        if(username.trim().equalsIgnoreCase(username_copy)) {
	        	System.out.println("username matches");
	        }
	        if(password.trim().equalsIgnoreCase(password_copy)) {
	        	System.out.println("password matches");
	        }
	        */
			con = DriverManager.getConnection(connectUrl,username,password);
			
	        
			if (con != null) {
				logger.info("Connection created Successfully !");
				System.out.println("Connection created Successfully !");
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} 
		return con;
	}
	
	/*public static void main(String args[]) {
		DBConnectionManager dbc = new DBConnectionManager();
		dbc.getConnection();
	}*/
}