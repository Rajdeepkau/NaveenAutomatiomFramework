package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RewardPage extends TestBase {
	public RewardPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div[id='account-reward']>div>div>p")
	WebElement rewardPointsHeading;


public String getTextForRewardPointsHeading() {
	return rewardPointsHeading.getText();
}
}
