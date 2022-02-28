package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTexbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTexbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTexbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTexbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTexbox;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement errorMessageAtFirstNameTextbox;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement errorMessageAtLastNameTextbox;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement errorMessageAtEmailTextbox;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement errorMessageAtPasswordTextbox;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement errorMessageAtConfirmPasswordTextbox;

	@FindBy(xpath = "//div[contains(@class, 'message-error')]//li")
	private WebElement errorMessageForExitEmail;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement successfulMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutButton;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, errorMessageAtFirstNameTextbox);
		return getElementText(driver, errorMessageAtFirstNameTextbox);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, errorMessageAtLastNameTextbox);
		return getElementText(driver, errorMessageAtLastNameTextbox);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, errorMessageAtEmailTextbox);
		return getElementText(driver, errorMessageAtEmailTextbox);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTexbox);
		sendkeyToElement(driver, firstNameTexbox, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTexbox);
		sendkeyToElement(driver, lastNameTexbox, lastName);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTexbox);
		sendkeyToElement(driver, emailTexbox, email);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTexbox);
		sendkeyToElement(driver, confirmPasswordTexbox, confirmPassword);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTexbox);
		sendkeyToElement(driver, passwordTexbox, password);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, successfulMessage);
		return getElementText(driver, successfulMessage);
	}

	public String getEmailErrorAlreadyExitMessage() {
		waitForElementVisible(driver, errorMessageForExitEmail);
		return getElementText(driver, errorMessageForExitEmail);

	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, errorMessageAtPasswordTextbox);
		return getElementText(driver, errorMessageAtPasswordTextbox);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutButton);
		clickToElement(driver, logoutButton);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, errorMessageAtConfirmPasswordTextbox);
		return getElementText(driver, errorMessageAtConfirmPasswordTextbox);
	}

}
