package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='email']")
	WebElement loginInput;
	@FindBy(css = "input[name='password']")
	WebElement passwordInput;
	@FindBy(css = "input[value='Login']")
	WebElement loginBtn;
	@FindBy(css = "div[class='alert alert-danger alert-dismissible']")
	WebElement warningMeassage;

	private void enterEmail(String email) {
		loginInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public String getAlertText() {
		return warningMeassage.getText();
	}

	public AccountPage clickLoginButton(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new AccountPage();
	}

}
