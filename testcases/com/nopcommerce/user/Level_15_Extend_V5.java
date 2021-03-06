package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest_Nopcommerce;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Level_15_Extend_V5 extends BaseTest_Nopcommerce {
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

//	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Click to RegisterLink");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register: Step_02: Enter to FirstName Textbox with value" + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register: Step_03: Enter to LastName Textbox with value" + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Step_04: Enter to Email Textbox with value" + email);
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register: Step_05: Enter to Password Textbox with value" + password);
		registerPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register: Step_06: Enter to Confirm Password Textbox with value" + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register: Step_07: Click to Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register: Step_08: Verify Success Register Message Displayed");
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_01: Click to Login Link");

		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_02: Enter to Email Textbox with value" + email);
		loginPage.InputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_03: Enter to Password Textbox with value" + password);
		loginPage.InputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_05: Verify My Account Link Displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_06: Click to My Account Link");
		customerInfoPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login: Step_07: Verify Customer Info Displayed");
		assertTrue(customerInfoPage.isCustomerInfoDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
