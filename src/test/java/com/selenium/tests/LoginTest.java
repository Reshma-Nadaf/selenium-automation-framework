package com.selenium.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.selenium.base.BaseTest;
import com.selenium.pages.LoginPage;
import com.selenium.utils.ConfigReader;
import com.selenium.utils.ExcelDataUtils;
import java.io.IOException;
import com.selenium.utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	
	@DataProvider(name = "loginData" , parallel = true)
	public Object[][] logindata() throws IOException
	{
		ExcelDataUtils data = new ExcelDataUtils("src\\test\\resources\\TestData.xlsx", "Login");
		
		int rows = data.getRowCount();
		int cols = data.getCellCount(); 
		 Object[][] dataObj  = new Object[rows-1][cols];
		
		 for(int i =1; i<rows; i++)
		 {
			 for(int j =0; j<cols; j++)
			 {
				 dataObj[i-1][j] = data.getCellData(i, j);
			 }
		 }
		 return dataObj;
	}
	
@Test(dataProvider = "loginData")
public void LoginTestScreener(String username, String password, String expectedResult) throws Exception
	{
		log.info("Logging that test started");
		
		String url = ConfigReader.get("url");
		getDriver().get(url);
		
		getDriver().manage().window().maximize();
		
		LoginPage login = new LoginPage(getDriver());
		
		login.Login(username, password);
		
		Assert.assertTrue(login.isLoginSuccessfull(), "Login not Successfull");
		
		 log.info("Test completed");
	
		
	}
}
