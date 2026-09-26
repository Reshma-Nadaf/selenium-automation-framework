package com.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.selenium.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By loginButton = By.xpath("//a[@class='button account']");
	private By userName = By.name("username");
	private By password = By.name("password");
	private By submit = By.xpath("//button[@type ='submit']");
	private By watchlist = By.xpath("//button[contains(.,'Core Watchlist')]");
	
	public void Login(String username, String passWord) {
		
		clickElement(loginButton);	
		enterText(userName, username);
		clickElement(password);
		enterText(password,passWord);
		clickElement(submit);
	}
	
	public boolean isLoginDone()
	{
		return !isEmptyEle(submit)
	            && !isDisplayed(submit);
	}
	
	public boolean isLoginSuccessfull()
	{
		return isDisplayed(watchlist);
		
	}
}
