package com.naveenautomation.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;

import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;

public class LogoutPageTest extends TestBase {

	private LogoutPage logoutpage;
	private LoginPage loginpage;
	private AccountPage accountpage;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();

	}

	@Test
	public void validateIfUserCanLogout() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		logoutpage = accountpage.clickLogoutOPtion(PageOptions.LOGOUT);
		Assert.assertEquals(logoutpage.getText(),
				"You have been logged off your account. It is now safe to leave the computer.",
				"Logout functionality fails!!!");
	}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}

}
