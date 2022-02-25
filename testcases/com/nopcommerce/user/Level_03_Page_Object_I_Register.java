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
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_I_Register {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		System.out.println(projectPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Hanh";
		lastName = "Dao Thi";
		email = "afc" + getRandomemailNumber() + "@gmail.com";
		password = "12345678@Abc";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01_Step_01_Click to Register Link");
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickToLogoutLink();

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
