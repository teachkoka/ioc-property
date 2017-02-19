package com.bellinfo.prop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertyLoaderWithPropFile {

	private Connection con;
	private Properties dbDetails;

	private String driver;
	private String url;
	private String username;
	private String password;
    public void setDbDetails(Properties dbDetails) {
		this.dbDetails = dbDetails;
		loadConDetails();
	}
	public void loadConDetails(){
		if(dbDetails != null){
			driver =dbDetails.getProperty("driver");
			url = dbDetails.getProperty("url");
			username = dbDetails.getProperty("username");
			password = dbDetails.getProperty("password");
		}
	}
	public void loadConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url, username, password);
		if(con!=null){
			System.out.println("Success : loading through java.utilProperties");
		}
		else{
			System.out.println("failed : loading through java.utilProperties");
		}		
	}
	
	public void closeConnection() throws SQLException{
		con.close();
	}
	
	
	
}
