package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
	
	

	public static WebDriver createDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
				return new ChromeDriver();
				}
		
		else if(browser.equalsIgnoreCase("edge")) {
				return new EdgeDriver();
				}
		else {
			throw new IllegalArgumentException("invalid Broser " + browser);	
			}
		
	}
	
	public static WebDriver createChromeDriver()
	{
		ChromeOptions options = new ChromeOptions();
		return new ChromeDriver(options);
	}
}
