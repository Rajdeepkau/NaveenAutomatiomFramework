package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class CheckoutPage extends TestBase {
	
		public CheckoutPage() {
			PageFactory.initElements(wd, this);

		}

		@FindBy(css = "a[class='accordion-toggle']")
		WebElement useCouponCode;
		@FindBy(css = "input[name='coupon']")
		WebElement inputCouponCode;
		@FindBy(css = "input[value='Apply Coupon']")
		WebElement applyCouponButton;
		@FindBy(css = "div[class='alert alert-danger alert-dismissible']")
		WebElement warningText;
		
		private void ClickCouponCodeLink() {
			useCouponCode.click();
		}
		private void enterCode(String code) {
			inputCouponCode.sendKeys(code);
		}
		public void clickApplyButton(String code) {
			ClickCouponCodeLink();
			enterCode(code);
			applyCouponButton.click();
		}
		public String warningText() {
			return warningText.getText();
		}
}
