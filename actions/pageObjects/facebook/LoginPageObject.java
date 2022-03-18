package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountLink() {
		waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_LINK);
	}

	public void senkeyToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressDisplayed() {
		waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public boolean isConfirmEmailAddressUnDisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void closeSinUpForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_SIGNUP_FORM_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_SIGNUP_FORM_ICON);
	}
}
