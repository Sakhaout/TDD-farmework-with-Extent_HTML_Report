package com.crmpro.page_testClass;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crmpro.base_page.BasePage;
import com.crmpro.extent_report.ExtentReportNG;
import com.crmpro.page_class.LogInPage;





@Listeners(ExtentReportNG.class)
public class LogInPageTest extends BasePage{
	LogInPage loginPage_Obj;
	private static Logger log = Logger.getLogger(LogInPageTest.class);
	
	public LogInPageTest() {
		super();	
	}


	@BeforeMethod
	public void setUp() {
		initialition();
		loginPage_Obj = new LogInPage();
	
	}
	
	@Parameters({"userName","password"})
	@Test
	public void LogInTest(String userName, String password){
		loginPage_Obj.logInFunction(userName, password);
		String title =driver.getTitle();
		Assert.assertEquals(title , "CRMPRO");
	}
	
	
	@AfterMethod
	public void closeDown() {
		driver.close();
		log.info("\tBrowser closed!!!");
	}

}
