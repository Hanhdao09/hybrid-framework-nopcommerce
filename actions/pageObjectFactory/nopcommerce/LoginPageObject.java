package pageObjectFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//button[contains(@class, 'login-button')]")
	private WebElement loginButton;

	@CacheLookup
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@CacheLookup
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@CacheLookup
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement errorMessage_atEmailTextbox;

	@CacheLookup
	@FindBy(xpath = "//div[contains(@class, 'message-error')]")
	private WebElement errorMessage_unsuccessful;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, errorMessage_atEmailTextbox);
		return getElementText(driver, errorMessage_atEmailTextbox);
	}

	public void InputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void InputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}

	public String getErrorMessageOfUnSuccessful() {
		waitForElementVisible(driver, errorMessage_unsuccessful);
		return getElementText(driver, errorMessage_unsuccessful);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

}
