package com.selenium.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import org.testng.annotations.Test;
import com.selenium.base.BaseTest;
import com.selenium.utils.ConfigReader;


public class HomePageTest extends BaseTest{
	//WebDriver driver ; -- not needed as its going take from base test 
	
	private static final Logger log = LogManager.getLogger(HomePageTest.class);
	@Test(groups= {"smoke"})
	public void verifyTitle()
	{
		log.info("Test started");
		String url = ConfigReader.get("url");
		getDriver().get(url);
		getDriver().manage().window().maximize();
		String title = getDriver().getTitle();
		Assert.assertEquals(title, "Stock Screener and fundamental analysis tool for Indian stocks - Screener", 
				"tilte is not correct");
	}

	

}
