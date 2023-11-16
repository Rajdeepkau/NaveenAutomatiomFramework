package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactPage;
import com.naveenautomation.pages.ContactSuccessPage;
import com.naveenautomation.pages.LoginPage;

public class ContactSuccessPageTest extends TestBase {
	private LoginPage loginpage;
	private AccountPage accountpage;
	private ContactPage contactpage;
	private ContactSuccessPage contactsuccesspage;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();
	}

	@Test
	public void validateIfUserCanContact() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		contactpage = accountpage.clickContactUsLink();
		contactsuccesspage = contactpage.clickSubmitButton("Can i get quotes for shipping charges");
		Assert.assertEquals(contactsuccesspage.getMessageText(),
				"Your enquiry has been successfully sent to the store owner!", "enquiry did not send properly ");
	}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}

}
