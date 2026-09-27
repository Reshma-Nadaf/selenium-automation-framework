package com.selenium.utils;

public class CredentialsReader {

	public static String getUsername()
	{
		String username = System.getenv("Test_Username");
		if(username != null && !username.isBlank())
		{
			return username;
		}
		
		return null;
	}
	
	public static String getPassword()
	{
		String password = System.getenv("Test_Password");
		if(password != null && !password.isBlank())
		{
			return password;
		}
		
		return null;
	}

	
}
