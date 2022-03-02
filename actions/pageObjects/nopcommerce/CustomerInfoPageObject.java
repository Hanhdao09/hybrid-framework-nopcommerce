package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.CustomerPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
	}

}
