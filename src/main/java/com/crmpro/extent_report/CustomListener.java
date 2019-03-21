package com.crmpro.extent_report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.crmpro.base_page.BasePage;
import com.crmpro.utilites.TestUtile;
import com.relevantcodes.extentreports.LogStatus;



public class CustomListener extends BasePage implements ITestListener {
	
	private TestUtile testUtile_obj = new TestUtile();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub


		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" (FAILED)");
		TestUtile.takeScreenshot(result.getMethod().getMethodName());



	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() +" (Skipped)	");		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		  System.out.println("I am in onStart method " + context.getName());
	      context.setAttribute("WebDriver", this.driver);
		
	}

	@Override
	public void onFinish(ITestContext context) {
        System.out.println("I am in onFinish method " + context.getName());
	

		// TODO Auto-generated method stub
		
	}

}
