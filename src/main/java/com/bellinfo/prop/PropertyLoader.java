package com.bellinfo.prop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Required;

public class PropertyLoader {
	private Connection con;
	private String driver;
	private String url;
	private String username;
	private String password;
	
	@Required
	public void setDriver(String driver) {
		this.driver = driver;
	}
	@Required
	public void setUrl(String url) {
		this.url = url;
	}
	@Required
	public void setUsername(String username) {
		this.username = username;
	}
	@Required
	public void setPassword(String password) {
		this.password = password;
	}
	public void loadConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url, username, password);
		if(con!=null){
			System.out.println("Success");
		}
		else{
			System.out.println("failed");
		}		
	}
	
	public void closeConnection() throws SQLException{
		con.close();
	}
	

}
