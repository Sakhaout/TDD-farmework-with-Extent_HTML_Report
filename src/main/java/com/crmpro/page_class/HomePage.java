package com.crmpro.page_class;

import java.io.IOException;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.base_page.BasePage;
import com.crmpro.utilites.Action;





public class HomePage extends BasePage{
	private static Logger log = Logger.getLogger(HomePage.class);
	Action action = new Action();
	
	By allList = By.tagName("li");
	
	@FindBy(xpath = "//td[contains(text(),'User: Hossain Sakhaout')]")
	private WebElement userLebel;
	
	
	
	@FindBy(xpath = "//div[@id='navMenu']//a[@title='Mail Accounts'][contains(text(),'Mail Accounts')]")
	private WebElement mailAccount_link;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath = "//a[contains(text(),'Messages')]")
	private WebElement message_link;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	private WebElement newContact;
	
	@FindBy(xpath = "//ul[@class='mlddm']//li[4]//ul[1]//li[2]//a[1]")
	private WebElement combinedFrom;
	

	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void getTable(){
		log.info("\tGetting data from table.");
		try {
			String before_xpath = "//*[@id=\"homebox_CALDAY\"]/table/tbody/tr[";
			String after_path = "]/td[1]";
			for(int i=1; i<=19;i++) {
				String date = driver.findElement(By.xpath(before_xpath+i+after_path)).getText();
				System.out.println("Get Data: "+date);

			}
		}catch(Exception ex) {
			log.error(ex.getStackTrace() +"\tGet failed to fatch data.");
		}
		
	}
	
	
	
		
	public void clickOnContactsLink() throws IOException {
		log.info("\tMouse is hovering on contactsLink.");
		action.actionMouseHover(contactsLink);
		log.info("\tClicking on Combined From.");
		combinedFrom.click();

	}
	
	
	
//	public void allLink(){
//		commonAction_obj.check_Link_connection(allList);
//				
//	}
	
	public void logout() {
		logout.click();
		log.info("\tSuccesfully loged out!!!");
	}
	
	
	
	

}
