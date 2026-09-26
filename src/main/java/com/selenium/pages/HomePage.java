package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.selenium.base.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	private By searchField = By.xpath("(//input[@type ='search'])[3]");
	private By heading = By.xpath("(//span[contains(text(),'HDFC Bank Ltd')])[2]");
	
	public void search(String text)
	{
		driver.findElement(searchField).sendKeys(text);
		driver.findElement(searchField).sendKeys(Keys.ENTER);		
	}
	
	public boolean isSearchSuccess()
	{
	 return isDisplayed(heading);
	}
}
