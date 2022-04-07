package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Nopcommerce;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_18_Pattern_Object extends BaseTest_Nopcommerce {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "afc" + getRandomNumber() + "@gmail.net";
		password = "12345678@Abc";
		dateOfBirthDay = "2";
		dateOfBirthMonth = "December";
		dateOfBirthYear = "1999";
	}

	@Test
	public void User_01_Register() {
		log.info("Register: Step_01: Click to Register Link");
		homePage.clickToHeaderLinkByText(driver, "Register");

		registerPage = PageGeneratorManager.getUserRegisterPage(driver);

		log.info("Register: Step_02: Click to Gender Radio");
		registerPage.clickToRadioByLabel(driver, "Female");

		log.info("Register: Step_03: Enter to FirstName Textbox with value '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register: Step_04: Enter to LastName Textbox with value '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register: Step_05: Select birthday");
		registerPage.selectDropdownByName(driver, dateOfBirthDay, "DateOfBirthDay");
		registerPage.selectDropdownByName(driver, dateOfBirthMonth, "DateOfBirthMonth");
		registerPage.selectDropdownByName(driver, dateOfBirthYear, "DateOfBirthYear");

		log.info("Register: Step_06: Enter to Email Textbox with value '" + email + "'");
		registerPage.inputToTextboxByID(driver, "Email", email);

		log.info("Register: Step_07: Click to checkbox By label");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register: Step_08: Enter to Password Textbox with value '" + password + "'");
		registerPage.inputToTextboxByID(driver, "Password", password);

		log.info("Register: Step_09: Enter to Confirm Password Textbox with value '" + password + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register: Step_10: Click to Register Button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register: Step_11: Verify Success Register Message Displayed");
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		log.info("Login: Step_01: Click to Login Link");
		registerPage.clickToHeaderLinkByText(driver, "Log out");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage.clickToHeaderLinkByText(driver, "Log in");

		loginPage = PageGeneratorManager.getUserLoginPage(driver);

		log.info("Login: Step_02: Enter to Email Textbox with value '" + email + "'");
		loginPage.inputToTextboxByID(driver, "Email", email);

		log.info("Login: Step_03: Enter to Password Textbox with value '" + password + "'");
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login: Step_04: Click to Login Button");
		loginPage.clickToButtonByText(driver, "Log in");
	}

	@Test
	public void User_03_My_Account() {
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("My account: Step_01: Verify My Account Link Displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("My account: Step_02: Click to My Account Link");
		homePage.clickToHeaderLinkByText(driver, "My account");

		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);

		log.info("My account: Step_03: Verify Customer Info Displayed");
		assertTrue(customerInfoPage.isCustomerInfoDisplayed());

		log.info("My account: Step_04: Verify Customer FirstName, LastName, Email");
		assertEquals(homePage.getTextboxValueByID(driver, "FirstName", "value"), firstName);
		assertEquals(homePage.getTextboxValueByID(driver, "LastName", "value"), lastName);
		assertEquals(homePage.getTextboxValueByID(driver, "Email", "value"), email);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	private String firstName, lastName, email, password, dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear;

}
