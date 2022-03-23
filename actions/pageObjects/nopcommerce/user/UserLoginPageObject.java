package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserHomePageUI;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to loggin button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Get error message at email textbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.ERRORMESSAGE_ATEMAILTEXTBOX);
		return getElementText(driver, UserLoginPageUI.ERRORMESSAGE_ATEMAILTEXTBOX);
	}

	@Step("Input to email textbox with value {0}")
	public void InputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input to password textbox with value {0}")
	public void InputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Get error message of unsuccessful")
	public String getErrorMessageOfUnSuccessful() {
		waitForElementVisible(driver, UserLoginPageUI.ERRORMESSAGE_UNSUCCESSFUL);
		return getElementText(driver, UserLoginPageUI.ERRORMESSAGE_UNSUCCESSFUL);
	}

	@Step("Verify My Account Link displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	@Step("Verify My Logout Link displayed")
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserLoginPageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserLoginPageUI.LOGOUT_LINK);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		return clickToLoginButton();
	}
}
