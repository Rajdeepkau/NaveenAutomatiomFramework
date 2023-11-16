package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ContactSuccessPage extends TestBase {
	public ContactSuccessPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//p[text()='Your enquiry has been successfully sent to the store owner!']")
	WebElement contactSuccessMessage;

	public String getMessageText() {
		return contactSuccessMessage.getText();
	}
}