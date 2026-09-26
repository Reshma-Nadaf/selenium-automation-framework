package com.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.utils.WaitUtils;

public class BasePage {
	protected WebDriver driver;
	protected WaitUtils waits;
	
	public BasePage(WebDriver driver)
	{
		this.driver= driver;
		this.waits = new WaitUtils(driver);
	}

	protected void clickElement(By element)
	{
		waits.waitForClickablityOfElement(element).click();
	}
	
	protected void enterText(By element, String text)
	{
		waits.waitForClickablityOfElement(element).sendKeys(text);
	}
	
	protected void clear(By element)
	{
		waits.waitForVisibilityOfElement(element).clear();
	}
	
	protected boolean isDisplayed(By element)
	{
		return waits.waitForVisibilityOfElement(element).isDisplayed();
	}
	
	protected boolean isEmptyEle(By element)
	{
		return driver.findElements(element).isEmpty();
	}

}
