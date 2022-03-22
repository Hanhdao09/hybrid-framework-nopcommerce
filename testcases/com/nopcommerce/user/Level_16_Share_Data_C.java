package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookies;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_C extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition: Step_01: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition: Step_02: Set Cookies and reload page");
		loginPage.setCookie(driver, Common_01_Register_Cookies.loggedCookies);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-condition: Step_03: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
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
