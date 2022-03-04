package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserCustomerPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, UserCustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerPageUI.CUSTOMER_INFO_HEADER);
	}

}
