package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.CheckoutPage;
import com.naveenautomation.pages.LoginPage;

public class CheckoutPageTest extends TestBase {
	LoginPage loginpage;
	AccountPage accountpage;
	CheckoutPage checkoutpage;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();
	}

	@Test
	public void validateInvalidCouponCode() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		checkoutpage = accountpage.clickCheckoutOption();
		checkoutpage.clickApplyButton("vgdsdtr65456");
		Assert.assertEquals(checkoutpage.warningText(),
				"Warning: Coupon is either invalid, expired or reached its usage limit!\n×",
				"Invalid coupon is working");

	}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}
}