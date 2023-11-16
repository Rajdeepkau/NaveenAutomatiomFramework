package com.naveenautomation.base;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.naveenautomation.utils.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;

	private final WindowOption DEFAULT_BROWSER = WindowOption.CHROME;
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;
	private static final boolean RUN_ON_GRID = true;

	@BeforeClass
	public void loggerSteup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public enum WindowOption {
		CHROME("Chrome"), EDGE("Edge"), FIREFOX("Firefox");

		private final String value;

		WindowOption(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public void intialisation(WindowOption option) {
		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://10.0.0.170:4444"),getOptions());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {

		switch (option) {
		case CHROME:
			wd = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			wd = WebDriverManager.edgedriver().create();
			break;
		case FIREFOX:
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new IllegalArgumentException();
		}
		}
		// Wrap the instance
		e_driver = new EventFiringWebDriver(wd);

		// Events which need to be captured
		events = new WebdriverEvents();
		e_driver.register(events);

		// Assigning back the value to Web driver
		wd = e_driver;

		wd.get(URL);

		wd.manage().window().maximize();

		wd.manage().deleteAllCookies();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void initializeDefaultBrowser() {
		intialisation(DEFAULT_BROWSER);
	}

	public enum PageOptions {
		MY_ACCOUNT("My Account"), EDIT_ACCOUNT("Edit Account"), PASSWORD("Password"), ADDRESS_BOOK("Address Book"),
		WISH_LIST("Wish List"), ORDER_HISTORY("Order History"), DOWNLOADS("Downloads"),
		RECURRING_PAYMENTS("Recurring payments"), REWARD_POINTS("Reward Points"), RETURNS("Returns"),
		TRANSACTIONS("Transactions"), NEWSLETTER("Newsletter"), LOGOUT("Logout");

		private final String value;

		PageOptions(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public void selectSideBarOption(PageOptions option) {
		List<WebElement> sideBarOption = wd.findElements(By.cssSelector("aside[id='column-right']>div>a"));
		for (int i = 0; i < sideBarOption.size(); i++) {
			if (sideBarOption.get(i).getText().toString().equals(option.getValue())) {
				sideBarOption.get(i).click();
				break;
			}
		}
	}

	public static void failedTestScreenShot(String testMethodName) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File screenShotFfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}
	}
	public MutableCapabilities getOptions() {
		return new ManageBrowserOptions().getOption(DEFAULT_BROWSER);
	}


	public void tearDown() {
		wd.quit();
	}
}