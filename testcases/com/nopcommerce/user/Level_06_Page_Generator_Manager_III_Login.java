package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Nopcommerce;
import pageObjects.nopcommerce.CustomerInfoPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III_Login extends BaseTest_Nopcommerce {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customInfoPage;
	private String firstName, lastName, foundEmail, password, invalidEmail, notFoundEmail, incorrectPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Hanh";
		lastName = "Dao";
		foundEmail = "afc" + getRandomNumber() + "@gmail.net";
		notFoundEmail = "afc" + getRandomNumber() + "@gmail.vn";
		invalidEmail = "123@abc@edf";
		password = "12345678@Abc";
		incorrectPassword = "12345678";

		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(foundEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_NotFoundEmail() {
		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageOfUnSuccessful(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_FoundEmail_IncorrectPassword() {
		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(foundEmail);
		loginPage.InputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageOfUnSuccessful(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_FoundEmail_CorrectPassword() {
		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(foundEmail);
		loginPage.InputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
		customInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customInfoPage.isCustomerInfoDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
