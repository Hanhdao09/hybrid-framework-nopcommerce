package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);

	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

}
