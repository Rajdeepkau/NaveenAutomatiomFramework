package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ProductDetailsPage extends TestBase {
	public ProductDetailsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div[class='caption']>h4>a")
	WebElement productTile;
	@FindBy(css = "div[class='caption']>p:nth-of-type(2)")
	WebElement productPrice;
	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCart;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	@FindBy(css = "button[data-original-title='Add to Wish List']")
	WebElement wishListButton;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement wishListSuccessMessage;
	@FindBy(xpath = "//span[text()='Wish List (1)']")
	WebElement wishListLink;
	@FindBy(css = "button[data-original-title='Compare this Product']")
	WebElement productComparison;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement productComparisonSuccessMessage;

	public String getTextOfTitle() {
		return productTile.getText();
	}

	public String getTextOfPrice() {
		return productPrice.getText();

	}

	public void clickOnAddToCart() {
		addToCart.click();

	}

	public String getTextOfSuccessForAddToCart() {
		return successMessage.getText();

	}

	public void clickOnAddToWishlist() {
		wishListButton.click();

	}

	public String getTextOfSuccessForAddToWishlist() {
		return wishListSuccessMessage.getText();

	}

	public WishlistPage clickOnWishListLink() {
		wishListLink.click();
		return new WishlistPage();
	}

	public void clickOnComparisonButton() {
		productComparison.click();

	}

	public String getTextOfSuccessForProductComparison() {
		return productComparisonSuccessMessage.getText();

	}

}
