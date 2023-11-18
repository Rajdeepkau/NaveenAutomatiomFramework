package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddressBookPage;
import com.naveenautomation.pages.LoginPage;

public class AddressBookPageTest extends TestBase {
	private LoginPage loginpage;
	private AccountPage accountpage;
	private AddressBookPage addresspage;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();
	}

	@Test(enabled=false)
	public void validateEditAddress() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		addresspage = accountpage.clickAddressBook(PageOptions.ADDRESS_BOOK);
		addresspage.clickContinue("r");
		Assert.assertEquals(addresspage.getAddressUpdateMessage(), "Your address has been successfully updated", "Address update message mismatch");
}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}

}
