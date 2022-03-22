package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_16_Share_Data_B extends BaseTest {
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

		log.info("Precondition: Step_09: Click to Login Link");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);
		loginPage = homePage.clickToLoginLink();

		log.info("Precondition: Step_10: Enter to Email Textbox with value '" + email + "'");
		loginPage.InputToEmailTextbox(email);

		log.info("Precondition: Step_11: Enter to Password Textbox with value '" + password + "'");
		loginPage.InputToPasswordTextbox(password);

		log.info("Precondition: Step_12: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Precondition: Step_13: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Precondition: Step_14: Click to My Account Link");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("Precondition: Step_15: Verify Customer Info Displayed");
		verifyTrue(customerInfoPage.isCustomerInfoDisplayed());

	}

	@Test
	public void Search_01_With_Empty_Data() {

	}

	@Test
	public void Search_02_With_Product_Relative_Name() {

	}

	@Test
	public void Search_03_With_Product_Absolute_Name() {

	}

	@Test
	public void Search_04_With_Parent_Category() {

	}

	@Test
	public void Search_05_With_Incorrect_Manufacturer() {

	}

	@Test
	public void Search_06_With_Incorrect_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
