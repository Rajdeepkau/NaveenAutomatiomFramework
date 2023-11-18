package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ReturnPage extends TestBase {
	public ReturnPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have not made any previous returns!']")
	WebElement returnMessage;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;
	@FindBy(css = "table[class='table table-bordered table-hover']>thead>tr>td:nth-of-type(1)")
	WebElement ReurntableCell;
	public String getReturnText() {
		return returnMessage.getText();
}
	public String getCellText() {
		return ReurntableCell.getText();
}
	

	public AccountPage clickContinueButton() {
		continueBtn.click();
		return new AccountPage();

	}
}
