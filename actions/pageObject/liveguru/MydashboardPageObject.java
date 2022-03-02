package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.MydashboardPageUI;

public class MydashboardPageObject extends BasePage {
	WebDriver driver;

	public MydashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, MydashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, MydashboardPageUI.ACCOUNT_LINK);
		waitForElementVisible(driver, MydashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MydashboardPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);
	}

	public boolean isSuccesfullMessageDisplayed() {
		waitForElementVisible(driver, MydashboardPageUI.SUCCESSFULL_MESSAGE);
		return isElementDisplayed(driver, MydashboardPageUI.SUCCESSFULL_MESSAGE);
	}
}
