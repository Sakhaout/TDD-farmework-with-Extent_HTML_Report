package com.crmpro.extent_report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.crmpro.base_page.BasePage;
import com.crmpro.utilites.TestUtile;



public class CustomListener extends BasePage implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() +" (PASSED)	");		



		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" (FAILED)");
		TestUtile.takeScreenshot(result.getMethod().getMethodName());
		String path = TestUtile.screenshot_final_path;
		Reporter.log("<a target = \"_blank\" href= "+path+">screenshot</a>");
		String path_1 = ("<a target = '_blank' href = '"+path+"' ><img height=200, width=200, src=\"" +path+"\"alt=\"\"/><img></a>");
		Reporter.log(path_1);



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
