package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class NewsletterPage extends TestBase {
	public NewsletterPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//input[@value='1']")
	WebElement SubscribeRadioButton;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	private void clickRadioButton() {
		SubscribeRadioButton.click();
	}

	public AccountPage clickContinue() {
		clickRadioButton();
		continueBtn.click();
		return new AccountPage();

	}

}
