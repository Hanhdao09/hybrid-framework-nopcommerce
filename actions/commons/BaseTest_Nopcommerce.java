package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//chứa các hàm dùng chung cho các testcase
//bổ trợ cho nguyên sourcesfolder testcases
public class BaseTest_Nopcommerce {
	protected WebDriver driver;
	protected String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(option);
		} else if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			// System.setProperty("webdriver.opera.driver", projectPath +
			// "\\browserDrivers\\operadriver.exe");
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver_97.exe");
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("brave")) {
			// System.setProperty("webdriver.chrome.driver", projectPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(option);
		} else {
			throw new RuntimeException("Browser Invalid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
