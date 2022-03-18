package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName, email, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);

		firstName = "Hanh";
		lastName = "Dao Thi";
		email = "afc" + getRandomemailNumber() + "@gmail.com";
		password = "12345678@Abc";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_01_Step_02_Click to Register Button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_02_Step_02_Input value to Textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123#35");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02_Step_03_Click to Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_03_Step_02_Input value to Textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03_Step_03_Click to Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLinkAtUserPage(driver);

	}

	@Test
	public void Register_04_Already_Exit_Email() {
		System.out.println("Register_04_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_04_Step_02_Input value to Textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04_Step_03_Click to Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorAlreadyExitMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Pass_Fewer6Character() {
		System.out.println("Register_05_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_05_Step_02_Input value to Textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("12345");

		System.out.println("Register_05_Step_03_Click to Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_FailConfirmPassword() {
		System.out.println("Register_06_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_06_Step_02_Input value to Textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("12334579");
		registerPage.inputToConfirmPasswordTextbox("1233457");

		System.out.println("Register_06_Step_03_Click to Register Button");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");
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
