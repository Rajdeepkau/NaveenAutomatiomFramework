package com.naveenautomation.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;



import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ReturnPage;



	public class ReturnPageTest extends TestBase {

		private LoginPage loginpage;
		private AccountPage accountpage;
		private ReturnPage returnpage;

	
		@BeforeMethod
		public void setUp() {
			initializeDefaultBrowser();
			loginpage = new LoginPage();
		}

		@Test(enabled=false)
		public void validateIfUserDidNotMakeAnyReturn() {
			accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		returnpage = accountpage.clickReturnOption();
			Assert.assertEquals(returnpage.getReturnText(), "You have not made any previous returns!","User is not on return page");
		}
		
		public void validateIfUserdidAReturn() {
			accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
			returnpage = accountpage.clickReturnOption();
			Assert.assertEquals(returnpage.getCellText(),"Return ID", "You have not made any previous returns!");
			
		}

		@AfterMethod
		public void closeDown() {
			tearDown();

		}
	}

