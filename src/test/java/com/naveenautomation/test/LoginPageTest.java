package com.naveenautomation.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.utils.ExcelUtils;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	AccountPage accountpage;

	@BeforeMethod
	public void setUp() {
		initializeDefaultBrowser();
		loginpage = new LoginPage();

	}

	@Test
	public void validateLoginCredentials() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		Assert.assertEquals(accountpage.getTextOfHeading(), "My Account", "User login attempt failed");

	}

	@Test
	public void validateIfUserCanNotLoginIn() {
		accountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur9999");
		Assert.assertEquals(loginpage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in successfully.");
	}

	@Test(dataProvider = "Userdata")
	public void valideIfUserCanLoginWithMultipleCredentials(String userName, String password) {
		accountpage = loginpage.clickLoginButton(userName, password);
		Assert.assertEquals(accountpage.getTextOfHeading(), "My Account", "User login attempt failed");

	}

	@DataProvider(name = "Userdata")
	public String[][] getDataFromExcel() throws Exception {
		String filename = "C:\\Users\\user\\Desktop\\userData.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(filename, sheetName);
		int cellCount = ExcelUtils.getCellCount(filename, sheetName, rowCount);
		// Ceating two dimentional array in order to fetch data from rows and columns//
		String[][] virtualSheet = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(filename, sheetName, i, j+1);

			}

		}
		return virtualSheet;
	}

	@AfterMethod
	public void closeDown() {
		tearDown();

	}
}
