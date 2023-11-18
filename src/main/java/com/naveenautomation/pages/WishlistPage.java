package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class WishlistPage extends TestBase {
	public WishlistPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "a[data-original-title='Remove']")
	WebElement removeButton;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement wislistChangeSuccesMessage;

	public void clickOnRemoveButtton() {
		removeButton.click();
	}

	public String getTextForSuccess() {
		return wislistChangeSuccesMessage.getText();
	}

}