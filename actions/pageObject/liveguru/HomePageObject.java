package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends BasePage {
	protected WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return new LoginPageObject(driver);
	}

}
