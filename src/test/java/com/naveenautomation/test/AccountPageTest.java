package com.naveenautomation.test;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;

import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsletterPage;
import com.naveenautomation.pages.PasswordPage;

public class AccountPageTest extends TestBase {

	PasswordPage passwordpage;
	LoginPage loginpage;
	AccountPage accountpage;
	NewsletterPage newsletter;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();

	}

	@Test
	public void validateIfUserCanChangePassword() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur9999");
		passwordpage = accountpage.clickPasswordOption(PageOptions.PASSWORD);
		accountpage = passwordpage.clickContinueButton("K@ur6879", "K@ur6879");
		Assert.assertEquals(accountpage.getTextOfSuccessMessage(),
				"Success: Your password has been successfully updated.", "Password is not updated as expected");
	}

	@Test
	public void validateNewsletterSubscription() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		newsletter = accountpage.clickNewsletterOption(PageOptions.NEWSLETTER);
		accountpage = newsletter.clickContinue();
		Assert.assertEquals(accountpage.getTextOfSuccessSubscriptionMessage(),
				"Success: Your newsletter subscription has been successfully updated!",
				"NewsLetter button is not selected");
	}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}
}
