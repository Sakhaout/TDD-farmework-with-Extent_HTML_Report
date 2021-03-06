package com.crmpro.extent_report;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.crmpro.base_page.BasePage;
import com.crmpro.utilites.TestUtile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * This class will generate Extent HTML Report along with the testNG class.
 * Also it will take screenshot for failure test, and show it on the Extent Report.
 * */

public class ExtentReportNG extends BasePage implements IReporter{
	private ExtentReports extent;
	public ExtentTest extentTest;


	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);


		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				}
				if(status.equals(LogStatus.FAIL)) {
					test.log(LogStatus.INFO, "Screenshot of failed test "+test.addScreenCapture(TestUtile.screenshot_final_path));
					System.out.println("DONE");
				}
				else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
				

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	
}
