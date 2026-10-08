package com.selenium.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import org.testng.annotations.Test;
import com.selenium.base.BaseTest;


public class GoggleTest extends BaseTest{
	//WebDriver driver ; -- not needed as its going take from base test 
	

	
	private static final Logger log = LogManager.getLogger(GoggleTest.class);
	@Test(groups= {"smoke"})
	public void verifyGoogleTitle()
	{
		log.info("Test started");
		String url = "https://www.google.com/";
		getDriver().get(url);
		getDriver().manage().window().maximize();
		String title = getDriver().getTitle();
		
		Assert.assertEquals(title, "Google", "tilte is not correct");
	}

	

}
