package com.nopcommerce.common;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookies extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static String firstName, lastName, email, password;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create New User for all Classes")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "afc" + getRandomNumber() + "@gmail.net";
		password = "12345678@Abc";

		log.info("Precondition: Step_01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Precondition: Step_02: Enter to FirstName Textbox with value '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Precondition: Step_03: Enter to LastName Textbox with value '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Precondition: Step_04: Enter to Email Textbox with value '" + email + "'");
		registerPage.inputToEmailTextbox(email);

		log.info("Precondition: Step_05: Enter to Password Textbox with value '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Precondition: Step_06: Enter to Confirm Password Textbox with value '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Precondition: Step_07: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Precondition: Step_08: Verify Success Register Message Displayed");
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Precondition: Step_09: Click to logout link at user page");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);

		log.info("Precondition: Step_10: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Precondition: Step_11: Enter to Email Textbox with value '" + email + "'");
		loginPage.InputToEmailTextbox(email);

		log.info("Precondition: Step_12: Enter to Password Textbox with value '" + password + "'");
		loginPage.InputToPasswordTextbox(password);

		log.info("Precondition: Step_13: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		loggedCookies = homePage.getAllCookies(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}