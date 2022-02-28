package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_05_Page_Object_Page_Factory extends BaseTest {
	private WebDriver driver;
	private pageObjectFactory.HomePageObject homePage;
	private pageObjectFactory.RegisterPageObject registerPage;
	private pageObjectFactory.LoginPageObject loginPage;
	private String firstName, lastName, foundEmail, password, invalidEmail, notFoundEmail, incorrectPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Hanh";
		lastName = "Dao";
		foundEmail = "afc" + getRandomemailNumber() + "@gmail.net";
		notFoundEmail = "afc" + getRandomemailNumber() + "@gmail.vn";
		invalidEmail = "123@abc@edf";
		password = "12345678@Abc";
		incorrectPassword = "12345678";

		homePage = new pageObjectFactory.HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new pageObjectFactory.RegisterPageObject(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(foundEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new pageObjectFactory.LoginPageObject(driver);

		System.out.println("Login_01_Step_02_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new pageObjectFactory.LoginPageObject(driver);

		System.out.println("Login_02_Step_02_Input to email textbox");
		loginPage.InputToEmailTextbox(invalidEmail);

		System.out.println("Login_01_Step_03_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_NotFoundEmail() {
		System.out.println("Login_03_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new pageObjectFactory.LoginPageObject(driver);

		System.out.println("Login_03_Step_02_Input to email textbox");
		loginPage.InputToEmailTextbox(notFoundEmail);

		System.out.println("Login_03_Step_03_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageOfUnSuccessful(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_FoundEmail_IncorrectPassword() {
		System.out.println("Login_04_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new pageObjectFactory.LoginPageObject(driver);

		System.out.println("Login_04_Step_02_Input to email textbox");
		loginPage.InputToEmailTextbox(foundEmail);

		System.out.println("Login_04_Step_03_Input to password textbox");
		loginPage.InputToPasswordTextbox(incorrectPassword);

		System.out.println("Login_04_Step_04_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageOfUnSuccessful(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_FoundEmail_CorrectPassword() {
		System.out.println("Login_05_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new pageObjectFactory.LoginPageObject(driver);

		System.out.println("Login_05_Step_02_Input to email textbox");
		loginPage.InputToEmailTextbox(foundEmail);

		System.out.println("Login_05_Step_03_Input to password textbox");
		loginPage.InputToPasswordTextbox(password);

		System.out.println("Login_05_Step_04_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());

	}

	public int getRandomemailNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
