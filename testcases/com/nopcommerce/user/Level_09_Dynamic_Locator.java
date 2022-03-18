package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myproductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

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

	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);

		loginPage = homePage.clickToLoginLink();
		loginPage.InputToEmailTextbox(email);
		loginPage.InputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoDisplayed());
	}

	@Test
	public void User_02_Switch_Page() {
		// CustomerInfo -> MyAddress
		addressPage = customerInfoPage.openAddressLinkMyAccount(driver);
		// MyAddress -> My Product Review
		myproductReviewPage = addressPage.openMyproducReviewLinkMyAccount(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myproductReviewPage.openRewardPointLinkMyAccount(driver);
		// Reward Point -> MyAddress
		addressPage = rewardPointPage.openAddressLinkMyAccount(driver);
		// MyAddress -> Reward Point
		rewardPointPage = addressPage.openRewardPointLinkMyAccount(driver);
		// Reward Point -> My Product Review
		myproductReviewPage = rewardPointPage.openMyproducReviewLinkMyAccount(driver);
	}

	@Test
	public void User_03_Dynamic_Page() {
		// My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myproductReviewPage.openPageAtMyAccountByName(driver,
				"Reward points");
		// Reward Point -> MyAddress
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		// MyAddress -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");
		// Reward Point -> My Product Review
		myproductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver,
				"My product reviews");
		// My Product Review-> CustomerInfo
		customerInfoPage = (UserCustomerInfoPageObject) myproductReviewPage.openPageAtMyAccountByName(driver,
				"Customer info");
	}

	@Test
	public void User_05_Switch_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
