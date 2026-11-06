package com.service;

import java.time.LocalDateTime;

public class LoginService 
{

	public boolean isValidUserAndPassword(String uname, String pass)
	{
		if(uname.equals("admin") && pass.equals("123Admin"))
		{
			System.out.println(LocalDateTime.now()+" Login success");
			return true;
		}
		return false;
	}
	
}
