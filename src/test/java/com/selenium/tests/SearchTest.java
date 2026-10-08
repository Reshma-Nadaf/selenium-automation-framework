package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseTest;
import com.selenium.pages.HomePage;
import com.selenium.utils.ConfigReader;


public class SearchTest extends BaseTest
{
	@Test(groups= {"regression"})
	public void searchText()
	{
		String url= ConfigReader.get("url");
		getDriver().get(url);
		getDriver().manage().window().maximize();
		HomePage home = new HomePage(getDriver());
		home.search("HDFC");
				
		Assert.assertTrue(home.isSearchSuccess(), "search is not successfull");
		
		
	}
}
