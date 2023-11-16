package com.naveenautomation.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.MacbookPage;


public class MacbookPageTest extends TestBase{

	
	LoginPage loginpage;
	AccountPage accountpage;
	MacbookPage macbookpage;

	
	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();

	}
	@Test
	public void validateIfSearchItemDisplayed() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		macbookpage=accountpage.enterSearchInput("macbook");
		Assert.assertTrue(macbookpage.isListButtonDisplayed(), "You are not searching a valid product");
	}
	@AfterMethod
	public void closeDown() {
		tearDown();

	}

}
