package com.naveenautomation.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RewardPage;

public class RewardPageTest extends TestBase {
	private LoginPage loginpage;
	private AccountPage accountpage;
	private RewardPage rewardpage;
	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();
}
	@Test
	public void validateNumberOfRewardPoints() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		rewardpage=accountpage.clickRewardPageLink(PageOptions.REWARD_POINTS);
		Assert.assertEquals(rewardpage.getTextForRewardPointsHeading(), "Your total number of reward points is: 0.","Total number of reward points are not showing");
	
	}
	
	@AfterMethod
	public void closeDown() {
		tearDown();

	}


}
