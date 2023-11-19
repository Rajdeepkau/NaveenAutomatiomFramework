package com.naveenautomation.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ProductDetailsPage;
import com.naveenautomation.pages.WishlistPage;

public class WishlistPageTest extends TestBase {
	private LoginPage loginpage;
	private AccountPage accountpage;
	private ProductDetailsPage productPage;
	private WishlistPage wishlistpage;
	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();
		
	}
	@Test(enabled=false)
	public void validateModificationInWishList() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		productPage=accountpage.selectOptionFromDesktops();
		productPage.clickOnAddToWishlist();
		wishlistpage=productPage.clickOnWishListLink();
		wishlistpage.clickOnRemoveButtton();
		System.out.println( productPage.getTextOfSuccessForAddToWishlist());
		Assert.assertEquals( productPage.getTextOfSuccessForAddToWishlist().replaceAll("\\s+", " ").trim(), "Success: You have modified your wish list! ×".trim(), "Product is not added to wishlist");
	}
	
	
	
	@AfterMethod
	public void closeDown() {
		tearDown();

	}
	

}
