package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LogoutPage extends TestBase {

	public LogoutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have been logged off your account. It is now safe to leave the computer.']")
	WebElement logoutMessage;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public String getText() {
		return logoutMessage.getText();
	}

	public void submitButton() {
		continueBtn.click();

	}
}
