package com.selenium.utils;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.base.BaseTest;
import com.selenium.utils.ScreenshotUtils;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started: "+ result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Passed: "+result.getName());
	}
	
	/*
	
	 @Override
	    public void onTestFailure(ITestResult result) {

		 System.out.println("Listener - driver = " + 
			        ((BaseTest) result.getInstance()).getDriver());
		 
	        System.out.println(
	                "Test Failed: " + result.getName()
	        );
	        

	        try {
	        	BaseTest test = (BaseTest)result.getInstance();

	            ScreenshotUtils.takeScreenshot(
	                    test.getDriver(),
	                    result.getName()
	            );

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
*/
	@Override
	public void onTestFailure(ITestResult result) {

	    System.out.println("Test Failed: " + result.getName());

	    System.out.println("Original failure:");
	    result.getThrowable().printStackTrace();

	    try {
	        BaseTest test = (BaseTest) result.getInstance();

	        if (test.getDriver() != null) {
	            ScreenshotUtils.takeScreenshot(
	                    test.getDriver(),
	                    result.getName()
	            );
	        } else {
	            System.out.println("Driver is null - screenshot not taken.");
	        }

	    } catch (Exception e) {
	        System.out.println("Screenshot could not be taken: " + e.getMessage());
	    }
	}
	
	    @Override
	    public void onTestSkipped(ITestResult result) {

	        System.out.println(
	                "Test Skipped: " + result.getName()
	        );
}
}
