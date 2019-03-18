package com.crmpro.page_testClass;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crmpro.base_page.BasePage;
import com.crmpro.extent_report.ExtentReportNG;
import com.crmpro.page_class.HomePage;
import com.crmpro.page_class.LogInPage;





@Listeners(ExtentReportNG.class)
public class HomePageTest extends BasePage {
	
	private HomePage HomePage_obj;
	private LogInPage login_obj;
	private Logger log = Logger.getLogger(HomePageTest.class);


	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	@Parameters({"userName","password"})
	public void setUp(String userName, String password) throws IOException {
		initialition();
		HomePage_obj = new HomePage();
		login_obj = new LogInPage();
		login_obj.logInFunction(userName,password);
		driver.switchTo().frame("mainpanel");
		
	}
	

//	@Test
//	public void printAllLink() throws InterruptedException{
//		Thread.sleep(5000);
//		HomePage_obj.allLink();
//	}
	
	
	@Test
	public void varifyTable() throws IOException {
		HomePage_obj.getTable();
	
	}
	
	@Test
	public void varifyContactLink() throws IOException {
		HomePage_obj.clickOnContactsLink();
	}
	

	
//	@Test
//	public void varifyLogout() {
//		HomePage_obj.logout();
//		String ActualURL = driver.getCurrentUrl();
//		String expectedURL = "https://classic.crmpro.com/index.html";
//		Assert.assertEquals(ActualURL, expectedURL);
//	}
	
	
	@AfterMethod
	public void closeDown() {
		driver.close();
		log.info("\tBrowser closed!!!");
	}
	

}
