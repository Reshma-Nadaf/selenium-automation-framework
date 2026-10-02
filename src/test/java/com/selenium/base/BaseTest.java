package com.selenium.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selenium.utils.ConfigReader;
import com.selenium.utils.WebDriverFactory;

public class BaseTest {
	//protected WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod(alwaysRun = true)
	public void setUp()
	{
		String broswer = ConfigReader.get("browser");
		WebDriver webdriver = WebDriverFactory.createDriver(broswer);
		driver.set(webdriver);
		log.info("Browser is set up");	
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		// log.info("TearDown - driver = " + driver.get());
		driver.get().quit();
		driver.remove();
		log.info("Browser is closed");
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}

}
