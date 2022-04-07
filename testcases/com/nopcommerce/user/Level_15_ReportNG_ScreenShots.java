package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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

public class Level_15_ReportNG_ScreenShots extends BaseTest_Nopcommerce {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	private String firstName, lastName, email, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "afc" + getRandomNumber() + "@gmail.net";
		password = "12345678@Abc";
	}

	@Test
	public void User_01_Register() {
		log.info("Register: Step_01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register: Step_02: Enter to FirstName Textbox with value '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register: Step_03: Enter to LastName Textbox with value '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register: Step_04: Enter to Email Textbox with value '" + email + "'");
		registerPage.inputToEmailTextbox(email);

		log.info("Register: Step_05: Enter to Password Textbox with value '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register: Step_06: Enter to Confirm Password Textbox with value '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register: Step_07: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Register: Step_08: Verify Success Register Message Displayed");
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

	}

	@Test
	public void User_02_Login() {
		log.info("Login: Step_01: Click to Login Link");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);
		loginPage = homePage.clickToLoginLink();

		log.info("Login: Step_02: Enter to Email Textbox with value '" + email + "'");
		loginPage.InputToEmailTextbox(email);

		log.info("Login: Step_03: Enter to Password Textbox with value '" + password + "'");
		loginPage.InputToPasswordTextbox(password);

		log.info("Login: Step_04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login: Step_05: Verify My Account Link Displayed");
		assertFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login: Step_06: Click to My Account Link");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("Login: Step_07: Verify Customer Info Displayed");
		assertFalse(customerInfoPage.isCustomerInfoDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
