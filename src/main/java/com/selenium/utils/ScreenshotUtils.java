package com.selenium.utils;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;

	public class ScreenshotUtils {

	    public static String takeScreenshot(WebDriver driver, String testName)
	            throws IOException {

	        TakesScreenshot ts = (TakesScreenshot) driver;

	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        String path = 
	        	System.getProperty("user.dir")+	"screenshots/" + testName + ".png";

	        File destination = new File(path);

	        destination.getParentFile().mkdirs();

	        Files.copy(source.toPath(), destination.toPath());

	        return path;
	    }
	}


