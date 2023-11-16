package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class PasswordPage extends TestBase {

	public PasswordPage() {
		PageFactory.initElements(wd, this);
	}
	@FindBy(css = "input[name='password']")
	WebElement paswordInput;
	@FindBy(css = "input[name='confirm']")
	WebElement paswordConfirmInput;
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;
	

	private void enterEmail(String email) {
		paswordInput.sendKeys(email);
	}
	private void enterPassword(String password) {
		paswordConfirmInput.sendKeys(password);
	}
	public AccountPage clickContinueButton(String email,String password) {
		enterEmail(email);
		enterPassword(password);
		continueBtn.click();
		return new AccountPage();
	}
	
	
}	
