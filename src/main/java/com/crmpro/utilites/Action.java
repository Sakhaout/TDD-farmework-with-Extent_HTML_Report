package com.crmpro.utilites;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.base_page.BasePage;


public class Action extends BasePage {
	

	public Action() {
		super();
	}


	//This method Perform DoubleClick on an Webelement.
	public void actionDoubleClick(WebElement webElement) {
		Actions action_obj = new Actions(driver);
		action_obj.doubleClick(webElement).perform();
	}


	//This methos perform mouse hover on webelement.
	public void actionMouseHover(WebElement element) throws IOException {
		//First need to creat an object of Actions class.
		try {
			Actions action_obj = new Actions(driver);
			action_obj.moveToElement(element).build().perform();
		}catch(Exception ex) {
			ex.getStackTrace();

		}

	}


	//This method will get tooltip text from inside an element.
	public String getTooltipText(WebElement element, WebElement tooltipElement) {
		//Need to creat an object of Actions class.
		Actions action = new Actions(driver);
		//Mouse hover on the element.
		action.moveToElement(element).perform();
		// Get tooltip text in a string.
		String ActualTooltip = tooltipElement.getText().toString();
		return ActualTooltip;
	}



	//This method will help to handle dropdown text.
	public void handleDropDown(WebElement element, String wanted_value) {
		// Need to create ofject of Select class.
		Select select = new Select(element);
		// Use one of the from Select class to get the value.
		select.selectByValue(wanted_value);
	}


	//This method perform drag and drop action.
	public void dragAndDrop(WebElement source, WebElement target) {
		//Need to creat an object of Actions class.
		Actions action = new Actions(driver);
		// Use dragAndDrop method of Actions class.
		action.dragAndDrop(source, target).perform();
	}


	//This method perform copy and pest action
	public void copyAndPasteAction(WebElement copyText, WebElement pasteText) {
		Actions action = new Actions(driver);
		//Select the text that wanted to be copy
		action.doubleClick(copyText).perform();
		//Use sendkeys() Copy the text
		copyText.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		//Paste text
		pasteText.sendKeys(Keys.chord(Keys.CONTROL,"v"));
	}




}
