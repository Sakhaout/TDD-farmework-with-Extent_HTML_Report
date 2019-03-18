package com.crmpro.page_class;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.base_page.BasePage;



public class LogInPage extends BasePage {
	
	
	private static Logger log = Logger.getLogger(LogInPage.class);
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement logIn_button;
	
	public LogInPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	

	
	public HomePage logInFunction(String userID, String pass){
		log.info("\tNow Login to the Application !!!");
		try {
			userName.sendKeys(userID);
			password.sendKeys(pass);
			logIn_button.click();
			log.info("\tLogin to the application");
		}catch(Exception ex) {
			log.error(ex.getStackTrace() +"\tFailed to Login");
		}
		
		return new HomePage();
	}

}
