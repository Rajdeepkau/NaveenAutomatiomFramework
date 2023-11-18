package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountPage extends TestBase {
	public AccountPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "div[id='content']>h2:first-of-type")
	WebElement myAccountHeading;
	@FindBy(xpath = "//a[text()='Password']")
	WebElement paswordOption;
	@FindBy(css = "div.list-group>a:nth-of-type(10)")
	WebElement returnOption;
	@FindBy(css = "div.list-group>a:nth-of-type(12)")
	WebElement newsletterOption;
	@FindBy(css = "div.list-group>a:nth-of-type(13)")
	WebElement logoutOption;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement passwordChangeSuccessMessage;
	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement subscriptionSuccessMessage;
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	WebElement shoppingCart;
	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsLink;
	@FindBy(css = "input[name='search']")
	WebElement searchInput;
	@FindBy(css = "i[class='fa fa-search']")
	WebElement searchbutton;
	@FindBy(css = "button[class='btn btn-link dropdown-toggle']")
	WebElement currencybutton;
	@FindBy(css = "ul[class='dropdown-menu']>li:nth-of-type(2)")
	WebElement poundCurrency;
	@FindBy(css = "ul[class='nav navbar-nav']>li:first-of-type")
	WebElement desktopsOption;
	@FindBy(css = "ul[class='nav navbar-nav']>li:first-of-type>div>div>ul>li:nth-of-type(2)")
	WebElement macBook;

	public String getTextOfHeading() {
		return myAccountHeading.getText();
	}

	public PasswordPage clickPasswordOption(PageOptions sideMenuSelected) {
		selectSideBarOption(sideMenuSelected);
		return new PasswordPage();
	}

	public ReturnPage clickReturnOption() {
		returnOption.click();
		return new ReturnPage();

	}

	public LogoutPage clickLogoutOPtion(PageOptions sideMenuSelected) {
		selectSideBarOption(sideMenuSelected);
		return new LogoutPage();
	}

	public String getTextOfSuccessMessage() {
		return passwordChangeSuccessMessage.getText();
	}

	public String getTextOfSuccessSubscriptionMessage() {
		return subscriptionSuccessMessage.getText();
	}

	public CheckoutPage clickCheckoutOption() {
		shoppingCart.click();
		return new CheckoutPage();

	}

	public ContactPage clickContactUsLink() {
		contactUsLink.click();
		return new ContactPage();

	}

	public MacbookPage enterSearchInput(String searchText) {
		searchInput.sendKeys(searchText);
		searchbutton.click();
		return new MacbookPage();
	}

	public NewsletterPage clickNewsletterOption(PageOptions sideMenuSelected) {
		selectSideBarOption(sideMenuSelected);
		return new NewsletterPage();
	}

	private void clickOnCurrency() {
		currencybutton.click();
	}

	public void selectFromCurrenyMenu() {
		clickOnCurrency();
		poundCurrency.click();
	}

	public String getTextForCurreny() {
		return currencybutton.getText();
	}

	public ProductDetailsPage selectOptionFromDesktops() {
		desktopsOption.click();
		macBook.click();
		return new ProductDetailsPage();
	}

	public AddressBookPage clickAddressBook(PageOptions sideMenuSelected) {
		selectSideBarOption(sideMenuSelected);
		return new AddressBookPage();
	}
	public RewardPage clickRewardPageLink(PageOptions sideMenuSelected) {
		selectSideBarOption(sideMenuSelected);
		return new RewardPage();
	}

}
