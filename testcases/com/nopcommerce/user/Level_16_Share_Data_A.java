package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		String email = Common_01_Register_End_User.email;
		String password = Common_01_Register_End_User.password;

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login: Step_01: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Login: Step_02: Enter to Email Textbox with value '" + email + "'");
		loginPage.InputToEmailTextbox(email);

		log.info("Login: Step_03: Enter to Password Textbox with value '" + password + "'");
		loginPage.InputToPasswordTextbox(password);

		log.info("Login: Step_04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

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

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
}
