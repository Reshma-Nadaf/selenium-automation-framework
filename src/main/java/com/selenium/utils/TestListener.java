package com.selenium.utils;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.base.BaseTest;

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
	
	 @Override
	    public void onTestFailure(ITestResult result) {

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

	    @Override
	    public void onTestSkipped(ITestResult result) {

	        System.out.println(
	                "Test Skipped: " + result.getName()
	        );
}
}
