package pageObject.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	protected WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return new UserLoginPageObject(driver);
	}

}
