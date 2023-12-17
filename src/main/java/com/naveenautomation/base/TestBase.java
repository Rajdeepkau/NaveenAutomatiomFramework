package com.naveenautomation.base;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import com.naveenautomation.utils.WebdriverEvents;

public class TestBase {

	public static WebDriver wd;
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebdriverEvents events;
	private static final boolean RUN_ON_GRID = false;
	private static final String BROWSER_PARAM = "browser";

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

	public static String getJenkinsParameter() {
		return System.getProperty(BROWSER_PARAM, "chrome");
	}

	public void initializeDefaultBrowser() {
		String browserOption = getJenkinsParameter();
		try {
			if (RUN_ON_GRID) {
				wd = new RemoteWebDriver(new URL("http://localhost:4444/ui"), getOptions());
			} else {
				switch (WindowOption.valueOf(browserOption.toUpperCase())) {
				case CHROME:
					wd = new ChromeDriver();
					break;
				case EDGE:
					wd = new EdgeDriver();
					break;
				case FIREFOX:
					wd = new FirefoxDriver();
					break;
				default:
					throw new IllegalArgumentException("Invalid browser option: " + browserOption);
				}
			}

			// Create an instance of your WebDriver events
			WebdriverEvents events = new WebdriverEvents();

			// Create an instance of EventFiringDecorator and decorate your WebDriver
			EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(events);
			wd = decorator.decorate(wd);

			wd.get(URL);

			wd.manage().window().maximize();
			wd.manage().deleteAllCookies();
			wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} catch (MalformedURLException e) {
			System.err.println("Error initializing WebDriver: " + e.getMessage());
			e.printStackTrace();
		}
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
		if (wd != null) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			File screenShotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenShotFile,
						new File("./FailedTestCasesScreenShot/" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
			} catch (IOException e) {
				System.out.println("The IO Exception is: " + e);
				e.printStackTrace();
			}
		} else {
			System.out.println("WebDriver is not initialized. Unable to take screenshot.");
		}
	}

	public MutableCapabilities getOptions() {
		String browserOption = getJenkinsParameter();
		return new ManageBrowserOptions().getOption(TestBase.WindowOption.valueOf(browserOption.toUpperCase()));
	}

	public void tearDown() {
		wd.quit();
	}
}