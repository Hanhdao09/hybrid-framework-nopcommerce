package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaException.BrowserNotSupportedException;

//chứa các hàm dùng chung cho các testcase
//bổ trợ cho nguyên sourcesfolder testcases
public class BaseTest_Orange_Hrm {
	protected WebDriver driver;
	protected final Log log;
	protected String projectPath = System.getProperty("user.dir");

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllFileInFolder();
	}

	protected BaseTest_Orange_Hrm() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(option);
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions option = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				option.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				option.setBinary("....");
			}
			driver = new ChromeDriver(option);
		} else if (browserList == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
			ChromeOptions option = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				option.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			} else {
				option.setBinary("....");
			}
			driver = new ChromeDriver(option);
		} else {
			throw new BrowserNotSupportedException(browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.PORTAL_DEV_URL);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(option);
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions option = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				option.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				option.setBinary("....");
			}
			driver = new ChromeDriver(option);
		} else if (browserList == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
			ChromeOptions option = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				option.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			} else {
				option.setBinary("....");
			}
			driver = new ChromeDriver(option);
		} else {
			throw new BrowserNotSupportedException(browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}

	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = GlobalConstants.PORTAL_DEV_URL;
		} else if (environment == EnvironmentList.TESTING) {
			envUrl = GlobalConstants.PORTAL_TESTING_URL;
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = GlobalConstants.ADMIN_TESTING_URL;
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = GlobalConstants.ADMIN_DEV_URL;
		}
		return envUrl;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	protected boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			log.info(" -------------------------- PASSED -------------------------- ");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	protected boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
