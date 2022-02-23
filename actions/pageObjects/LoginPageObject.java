package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.ERRORMESSAGE_ATEMAILTEXTBOX);
		return getElementText(driver, LoginPageUI.ERRORMESSAGE_ATEMAILTEXTBOX);
	}

	public void InputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void InputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageOfUnSuccessful() {
		waitForElementVisible(driver, LoginPageUI.ERRORMESSAGE_UNSUCCESSFUL);
		return getElementText(driver, LoginPageUI.ERRORMESSAGE_UNSUCCESSFUL);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, LoginPageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, LoginPageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, LoginPageUI.LOGOUT_LINK);
	}

}
