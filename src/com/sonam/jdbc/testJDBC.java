package com.sonam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {

	public static void main(String[] args)
	{
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
	//	 String driver = "com.mysql.cj.jdbc.Driver"; 
		String user="hbstudent";
		String pass="hbstudent";
		try
		{
		//	Class.forName(driver).newInstance();
			System.out.println("Connecting to database");	
			Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful to database");	
					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
