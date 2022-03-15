package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_Liveguru;
import pageObject.liveguru.user.UserHomePageObject;
import pageObject.liveguru.user.UserLoginPageObject;
import pageObject.liveguru.user.MydashboardPageObject;
import pageObject.liveguru.user.PageGeneratorManager;
import pageObject.liveguru.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III_Register_Login extends BaseTest_Liveguru {
	private WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	MydashboardPageObject mydashboardPage;
	String firstName, lastName, email, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Hanh";
		lastName = "Dao";
		email = "hanhdao" + getRandomNumber() + "@gmail.com";
		password = "12345678@Abc";
	}

	@Test
	public void User_01_RegisterToSystem() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAccountButton();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		mydashboardPage = registerPage.clickToRegisterButton();
		Assert.assertTrue(mydashboardPage.isSuccesfullMessageDisplayed());
		homePage = mydashboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_LoginToSystem() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		mydashboardPage = loginPage.clickToLoginButton();
		homePage = mydashboardPage.clickToLogoutLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
