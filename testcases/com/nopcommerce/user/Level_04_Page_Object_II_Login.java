package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Page_Object_II_Login {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, foundEmail, password, invalidEmail, notFoundEmail, incorrectPassword;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		firstName = "Hanh";
		lastName = "Dao";
		foundEmail = "afc" + getRandomemailNumber() + "@gmail.net";
		notFoundEmail = "afc" + getRandomemailNumber() + "@gmail.vn";
		invalidEmail = "123@abc@edf";
		password = "12345678@Abc";
		incorrectPassword = "12345678";

		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_01_Step_02_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Step_01_Click to login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

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
		loginPage = new LoginPageObject(driver);

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
		loginPage = new LoginPageObject(driver);

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
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_05_Step_02_Input to email textbox");
		loginPage.InputToEmailTextbox(foundEmail);

		System.out.println("Login_05_Step_03_Input to password textbox");
		loginPage.InputToPasswordTextbox(password);

		System.out.println("Login_05_Step_04_Click to login button");
		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
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
