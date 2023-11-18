package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AddressBookPage extends TestBase {
	public AddressBookPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement editButton;
	@FindBy(css = "input[name='lastname']")
	WebElement lastname;
	@FindBy(css = "input[type='submit']")
	WebElement continueButton;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement addressSuccessMessage;

	private void clickEditButton() {
		editButton.click();
	}

	private void enterInLastnameField(String lastName) {
		lastname.sendKeys(lastName);

	}

	public void clickContinue(String lastName) {
		clickEditButton();
		enterInLastnameField(lastName);
		continueButton.click();

	}

	public String getAddressUpdateMessage() {
		return addressSuccessMessage.getText();
	}

}
