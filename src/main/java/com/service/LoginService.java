package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class LoginService 
{
	public boolean isValidUserAndPassword(String uname, String pass)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDrive","root","123@Javac");	
			System.out.println("Connection established "+con);
			
			PreparedStatement ps = con.prepareStatement("select * from users where username = ? and password = ?");
			
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
		
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		
		return false;
	}
	
}
