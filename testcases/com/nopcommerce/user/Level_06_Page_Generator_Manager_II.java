package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_II extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Hanh";
		lastName = "Dao Thi";
		email = "afc" + getRandomNumber() + "@gmail.com";
		password = "12345678@Abc";
	}

	@Test
	public void Register_01_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123#35");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_04_Already_Exit_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorAlreadyExitMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Pass_Fewer6Character() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_FailConfirmPassword() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("12334579");
		registerPage.inputToConfirmPasswordTextbox("1233457");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
