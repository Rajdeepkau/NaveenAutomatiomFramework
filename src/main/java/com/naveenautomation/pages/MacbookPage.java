package com.naveenautomation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MacbookPage extends TestBase {
	 {
		PageFactory.initElements(wd, this);

	}
	 @FindBy(css = "button[id='list-view']")
		WebElement listViewButton;
	 
	 public  boolean isListButtonDisplayed() {
		 listViewButton.isDisplayed();
		return true;
		 
	 }
}
