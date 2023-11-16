package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends AccountPage {
	public ContactPage() {
		PageFactory.initElements(wd, this);

	}
	@FindBy(css = "input[name='name']")
	WebElement inputname;
	@FindBy(css = "input[name='email']")
	WebElement inputEmail;
	@FindBy(css = "textarea[name='enquiry']")
	WebElement enquirytext;
	@FindBy(css = "input[type='submit']")
	WebElement submitButton;
	
	
	private void enterEnquiryMessage(String text) {
		enquirytext.sendKeys(text);
	}
	public ContactSuccessPage clickSubmitButton(String text) {
		  enterEnquiryMessage(text);
		submitButton.click();
		return new ContactSuccessPage() ;
	}

}
