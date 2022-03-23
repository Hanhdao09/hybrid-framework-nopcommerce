package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserCustomerPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Customer Info displayed")
	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, UserCustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerPageUI.CUSTOMER_INFO_HEADER);
	}

}
