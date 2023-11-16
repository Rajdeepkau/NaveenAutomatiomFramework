package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductDetailsPage;

public class ProductDetailsPageTest extends TestBase {
	private AccountPage accountpage;
	private LoginPage loginpage;
	private ProductDetailsPage productPage;
	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();

	}
	@Test
	public void validateTiltleOfProduct() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		Assert.assertEquals(productPage.getTextOfTitle(), "iMac","Title of the product was not matched");
	}
	@Test
	public void validatePriceOfProduct() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		System.out.println(productPage.getTextOfPrice());
		Assert.assertTrue(productPage.getTextOfPrice().contains("$100"), "Price is not equal to actual amount");
	}
	@Test(enabled=false)
	public void validateAddToCart() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		productPage.clickOnAddToCart();
		System.out.println(productPage.getTextOfSuccessForAddToCart());
		Assert.assertEquals(productPage.getTextOfSuccessForAddToCart().replaceAll("\\s+", " ").trim(), "Success: You have added iMac to your shopping cart! ×".trim(),"Product is not added to cart");
	}
	@Test
	public void validateItemAddToWishlist() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		productPage.clickOnAddToWishlist();
		Assert.assertEquals(productPage.getTextOfSuccessForAddToWishlist().replaceAll("\\s+", " ").trim(), "Success: You have added iMac to your wish list! ×".trim(),"Product is not added to wishlist");
	}
	@Test
	public void validateCompareProductButton() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		productPage.clickOnComparisonButton();
		Assert.assertEquals(productPage.getTextOfSuccessForProductComparison().replaceAll("\\s+", " ").trim(), "Success: You have added iMac to your product comparison! ×".trim(),"Product is not added to your product Comparison");
	}
	
	
	@AfterMethod
	public void closeDown() {
		tearDown();

	}

}
